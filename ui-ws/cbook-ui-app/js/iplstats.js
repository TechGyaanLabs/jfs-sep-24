 // Load the Visualization API and the corechart package.
 google.charts.load('current', {'packages':['corechart']});

async function getTeamDetails() {
    try {
        const response = await fetch("js/ipl2020.json");
        const data = await response.json();
        return data;
    } catch (error) {
        console.log(error);
        return []; // Return an empty array in case of error
    }
}

async function showTotalAmount() {
    try {
        const teams = await getTeamDetails(); // Await the result of getTeamDetails
        let teamAmout = new Map();
        teams.forEach(team => {
            let players = team.players;
            let totalAmount = 0;
            players.forEach(player => {
                totalAmount += player.price;
            });
            teamAmout.set(team.name, totalAmount);
       
        });
        data  = [];
        teamAmout.forEach((value, key) => {
            data.push([key, value]);
        });
        google.charts.setOnLoadCallback(drawTeamAmountChart(data));
        console.log(teamAmout);
    } catch (error) {
        console.log("Error calculating total amount:", error);
    }
}

async function showRoleCount() {
    try {
        const teams = await getTeamDetails(); // Await the result of getTeamDetails
        let roleCount = new Map();
        teams.forEach(team => {
            let players = team.players;
            players.forEach(player => {
                let role = player.role;
                if (roleCount.has(role)) {
                    roleCount.set(role, roleCount.get(role) + 1);
                } else {
                    roleCount.set(role, 1);
                }
            });
        });
        let data = [];
        roleCount.forEach((value, key) => {
            data.push([key, value]);
        });
        google.charts.setOnLoadCallback(drawRoleCountChart(data));
    } catch (error) {
        console.log("Error calculating role count:", error);
    }    
}


function drawTeamAmountChart(inputData) {
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Team');
    data.addColumn('number', 'Amount');
    data.addRows(inputData);

    // Set chart options
    var options = {'title':'Team Amount in IPL 2020',
                   'width':400,
                   'height':300};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.ColumnChart(document.getElementById('idTeamAmount'));
    chart.draw(data, options);
  }

  function drawRoleCountChart(inputData) {
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Role');
    data.addColumn('number', 'Number of Players');
    data.addRows(inputData);

    // Set chart options
    var options = {'title':'Role Count IPL 2020',
                   'width':400,
                   'height':300};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('idRoleCount'));
    chart.draw(data, options);
  }

  async function showPlayersCount() {
    try {
        const teams = await getTeamDetails(); // Await the result of getTeamDetails
        let teamPlayers = new Map();
        teams.forEach(team => {
            let players = team.players;
            teamPlayers.set(team.name, players.length);
        });
        let data = [];
        teamPlayers.forEach((value, key) => {
            data.push([key, value]);
        });
        google.charts.setOnLoadCallback(drawPlayersCountChart(data));
    } catch (error) {
        console.log("Error calculating players count:", error);
    }
}

function drawPlayersCountChart(inputData) {
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Team');
    data.addColumn('number', 'Number of Players');
    data.addRows(inputData);

    // Set chart options
    var options = {'title':'Players Count in IPL 2020',
                   'width':400,
                   'height':300};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.BarChart(document.getElementById('idPlayerCount'));
    chart.draw(data, options);
  }

// Call the function
showTotalAmount();
showPlayersCount();
showRoleCount();


