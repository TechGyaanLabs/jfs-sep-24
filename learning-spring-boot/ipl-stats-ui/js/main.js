const API_BASE_URL = "https://jfs-sep-24-rgax.onrender.com/api/v1/ipl/stats";
google.charts.load('current', { packages: ['corechart'] });
google.charts.setOnLoadCallback(initializeCharts);

// Initialize the charts
async function initializeCharts() {
    try {
        const [teamAmount, roleCount, countryData] = await Promise.all([
            fetchData('/team-amount'),
            fetchData('/role-count'),
            fetchData('/player-count-by-country')
        ]);

        drawTeamAmountChart(teamAmount);
        drawRoleCountChart(roleCount);
        drawCountryChart(countryData);
    } catch (error) {
        console.error('Failed to initialize charts:', error);
    }
}

function createChart(config) {
    try {
        const {
            elementId,
            data,
            columns,
            options,
            chartType
        } = config;

        const chartData = new google.visualization.DataTable();
        chartData.addColumn('string', columns.label);
        chartData.addColumn('number', columns.value);

        data.forEach(item => {
            chartData.addRow([item[columns.labelKey], item[columns.valueKey]]);
        });

        const chart = new google.visualization[chartType](document.getElementById(elementId));
        chart.draw(chartData, options);
    } catch (error) {
        console.error(`Failed to create ${config.chartType}:`, error);
    }
}

function drawTeamAmountChart(response) {
    createChart({
        elementId: 'teamAmountChart',
        data: response.data,
        columns: {
            label: 'Team',
            value: 'Amount',
            labelKey: 'team',
            valueKey: 'amount'
        },
        options: {
            title: 'Team Spending (₹ Cr)',
            legend: { position: 'none' },
            hAxis: { title: 'Teams' },
            vAxis: { title: 'Amount' }
            
        },
        chartType: 'ColumnChart'
    });
}

function drawRoleCountChart(response) {
    createChart({
        elementId: 'roleCountChart',
        data: response.data,
        columns: {
            label: 'Role',
            value: 'Count',
            labelKey: 'role',
            valueKey: 'count'
        },
        options: {
            title: 'Role Counts',
            pieHole: 0.4,
            pieSliceText: 'value'
        },
        chartType: 'PieChart'
    });
}

function drawCountryChart(response) {
    createChart({
        elementId: 'countryChart',
        data: response.data,
        columns: {
            label: 'Country',
            value: 'Players',
            labelKey: 'country',
            valueKey: 'count'
        },
        options: {
            title: 'Country-wise Player Count',
            pieHole: 0.4,
            pieSliceText: 'value'
        },
        chartType: 'PieChart'
    });
}
// Utility to fetch data from API
async function fetchData(endpoint) {
    try {
        const response = await fetch(`${API_BASE_URL}${endpoint}`);
        if (!response.ok) throw new Error("Failed to fetch data");
        return await response.json();
    } catch (error) {
        console.error(error);
        return [];
    }
}

// Helper Functions
function createTableHeader(columns) {
    return `
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>${columns.map(col => `<th>${col}</th>`).join('')}</tr>
            </thead>
            <tbody>
    `;
}

function createTableRow(data, keys) {
    return `
        <tr>
            ${keys.map(key => `<td>${key === 'price' ? '₹' : ''}${data[key]}</td>`).join('')}
        </tr>
    `;
}

function createTable(data, columns, keys) {
    return `
        ${createTableHeader(columns)}
        ${data.map(item => createTableRow(item, keys)).join('')}
        </tbody></table>
    `;
}

// Main Functions
async function loadTeamNames() {
    try {
        const { data: { teamNames = [] } } = await fetchData("/team-names");
        document.getElementById("teamNames").innerHTML = teamNames
            .map(team => `
                <div class="col-md-3 border p-2 my-2 bg-primary text-white" 
                     onclick="loadTeamStats('${team}')" 
                     style="cursor: pointer">
                    ${team}
                </div>
            `).join('');
    } catch (error) {
        console.error('Failed to load team names:', error);
    }
}

async function loadTeamStats(team) {
    try {
        const { data: { topPlayers, topPaidPlayerOfEachRole, players } } = await fetchData(`/team-stats/${team}`);
        const topPlayer = topPlayers[0];

        // Top Paid Player
        document.getElementById("topPaidPlayer").innerHTML = `
            <h5 class="text-primary">${topPlayer.name}</h5>
            <p>Role: ${topPlayer.role}<br>
               Country: ${topPlayer.country}<br>
               Team: ${topPlayer.team}<br>
               Price: ₹${topPlayer.price} Cr</p>
        `;

        // Role-wise Players Table
        const roleWisePlayers = Object.entries(topPaidPlayerOfEachRole)
            .flatMap(([role, players]) => players.map(player => ({ ...player, role })));

        document.getElementById("roleWiseMaxPaidPlayers").innerHTML = createTable(
            roleWisePlayers,
            ['Role', 'Name', 'Country', 'Team', 'Price (Cr)'],
            ['role', 'name', 'country', 'team', 'price']
        );

        // All Players Table
        document.getElementById("allPlayers").innerHTML = createTable(
            players,
            ['Name', 'Role', 'Country', 'Team', 'Price (Cr)'],
            ['name', 'role', 'country', 'team', 'price']
        );

        document.getElementById("teamStatsSection").style.display = "block";
    } catch (error) {
        console.error('Failed to load team stats:', error);
    }
}


// show top paid player of each team
async function loadTopPaidPlayers() {
    try {
        const { data } = await fetchData("/top-paid-players");
        document.getElementById("teamTopPaidPlayers").innerHTML = createTable(
            data,
            ['Name', 'Role', 'Country', 'Team', 'Price (Cr)'],
            ['name', 'role', 'country', 'team', 'price']
        );
    } catch (error) {
        console.error('Failed to load top paid players:', error);
    }
}

loadTeamNames(); // Load team names on page load
initializeCharts() // Load charts on page load
loadTopPaidPlayers(); // Load top paid players on page load