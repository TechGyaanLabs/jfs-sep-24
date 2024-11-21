 // Load the Visualization API and the corechart package.
 google.charts.load('current', {'packages':['corechart']});
 teamName = "";
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


async function getTeamNameAndLabel() {
    try{
        let teams = await getTeamDetails();
        let teamBasicDetails = [];
        teams.forEach(team => {
            teamBasicDetails.push({name: team.name, label: team.label});
        });
        return teamBasicDetails;
    }catch(error){
        console.log(error);
    }
}

async function showTeamStats() {
    let teamLabel = document.getElementById('idTeamName').value;
    teamName = teamLabel;
    if(teamLabel === ""){
        return;
    }
    const teams = await getTeamDetails();
    let team = teams.find(t => t.label === teamLabel);
    let players = team.players;

    let roleCount = [];
    let roleCountMap = new Map();
    players.forEach(player => {
        let role = player.role;
        if (roleCountMap.has(role)) {
            roleCountMap.set(role, roleCountMap.get(role) + 1);
        } else {
            roleCountMap.set(role, 1);
        }
    });
    roleCountMap.forEach((value, key) => {
        roleCount.push([key, value]);
    });

    let roleAmount = [];
    let roleAmountMap = new Map();
    players.forEach(player => {
        let role = player.role;
        if (roleAmountMap.has(role)) {
            roleAmountMap.set(role, roleAmountMap.get(role) + player.price);
        } else {
            roleAmountMap.set(role, player.price);
        }
    });
    roleAmountMap.forEach((value, key) => {
        roleAmount.push([key, value]);
    })

    showPlayersDetails(players,'idTeamPlayers');
    google.charts.setOnLoadCallback(drawTeamRoleCountChart(roleCount));
    google.charts.setOnLoadCallback(drawTeamRoleAmountChart(roleAmount));
}

function showPlayersDetails(players,divIdName) {

    let str = '<table class="table table-bordered table-striped">';
    str += '<tr><th>Name</th><th>Role</th><th>Price</th></tr>';
    players.forEach(player => {
        str += `<tr><td>${player.name}</td><td>${player.role}</td><td>${player.price}</td></tr>`;
    });
    str += '</table>';
    document.getElementById(divIdName).innerHTML = str;

}

function drawTeamRoleCountChart(inputData) {

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Role');
    data.addColumn('number', 'Number of Players');
    data.addRows(inputData);

    var options = {'title':'Role Count',
                   'width':400,
                   'height':300};

    let chart = new google.visualization.PieChart(document.getElementById('idTeamRoleCountStats'));
    chart.draw(data, options);
    google.visualization.events.addListener(chart, 'select', () =>{
        let selection = chart.getSelection();
        let role = data.getValue(selection[0].row, 0);
        showTeamPlayerOfGivenRole(teamName,role);
        
    });

}

async function showTeamPlayerOfGivenRole(teamName, role) {
    let teams = await getTeamDetails();
    let team = teams.find(t => t.label === teamName);
    let players = team.players;
    let playersOfRole = players.filter(player => player.role === role);
    showPlayersDetails(playersOfRole,'idPlayersOfRole');
}

function drawTeamRoleAmountChart(inputData) {

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Role');
    data.addColumn('number', 'Amount');
    data.addRows(inputData);

    var options = {'title':'Role Amount',
                   'width':400,
                   'height':300};

    var chart = new google.visualization.ColumnChart(document.getElementById('idTeamRoleAmountStats'));
    chart.draw(data, options);
}

async function renderSelectOptionOfTeamBasicDetails() {
   
    let teamBasicDetails = await getTeamNameAndLabel();
    console.log(teamBasicDetails);
    let str = '<select class="form-control" id="idTeamName" onchange="showTeamStats()">';
    str += '<option value="">Select Team</option>';
    teamBasicDetails.forEach(team => {
        str += `<option value="${team.label}">${team.name}</option>`;
    });
    str += '</select>';
    document.getElementById('idTeamNameDiv').innerHTML = str;
}

// Call the function
showTotalAmount();
showPlayersCount();
showRoleCount();
renderSelectOptionOfTeamBasicDetails();

