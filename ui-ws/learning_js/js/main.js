function showDate() {
    idDateResult = document.querySelector("#idDateResult");
    idDateResult.innerHTML = new Date();
}
function onAndOff() {
    idImg = document.querySelector("#idImg");
    imageName = idImg.src;
    if (imageName.includes("off.gif")) {
        idImg.src = 'img/bulbon.gif'
    } else {
        idImg.src = 'img/bulboff.gif'
    }
}
function convertToUpper() {
    let text = document.querySelector("#idText").value;
    document.querySelector("#idTextResult").innerHTML = text.toUpperCase();
}

const idShowUsers = document.querySelector("#idShowUsers");
const idShowPlayers = document.querySelector("#idShowPlayers")


idShowUsers.addEventListener("click", () => {
    let str = `<table class="table">
                        <thead>
                            <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Mobile</th>
                            </tr>
                        </thead>`;
    str += `<tbody>`;


    users.forEach((user) => {
        str += `<tr>`;
        str += `<th scope="row">${user.id}</th>`;
        str += `<td>${user.name}</td>`;
        str += `<td>${user.email}</td>`;
        str += `<td>${user.mobile}</td>`;
        str += `</tr>`;
    }
    );
    str += "</tbody>";
    str += "</table>";
    document.querySelector("#idUserList").innerHTML = str;
});

idShowPlayers.addEventListener("click", () => {
    alert("Show players");
});


const users = [
    {
        "id": 1,
        "name": "John Doe",
        "email": "john.doe@gmail.com",
        "mobile": "9087654322"
    },
    {
        "id": 2,
        "name": "Krishna",
        "email": "krish.t@gmail.com",
        "mobile": "9876543210"
    },
    {
        "id": 3,
        "name": "Rama",
        "email": "rama@gmail.com",
        "mobile": "9876543213"
    }

];


const players = [
    {
        "id": 1,
        "name": "Sachin",
        "age": 45,
        "country": "India"
    },
    {
        "id": 2,
        "name": "Kohli",
        "age": 35,
        "country": "India"
    },
    {
        "id": 3,
        "name": "Smith",
        "age": 32,
        "country": "Australia"
    },
    {
        "id": 4,
        "name": "Root",
        "age": 30,
        "country": "England"
    }
]

const idUserName =  document.querySelector("#idUserName");
const userList = [];
const idNameList = document.querySelector("#idNameList");

showUserDetails();
let isEditOn = false;
let index = -1;

idUserName.addEventListener("keyup", (event) => {
    
        if(event.keyCode === 13) {
            let userName = event.target.value;
            if(userName.length > 0 && !isEditOn){ 
               userList.push(userName);
               showUserDetails();
               event.target.value = "";
            }else if(userName.length > 0 && isEditOn){
                userList[index] = userName;
                showUserDetails();
                event.target.value = "";
                isEditOn = false;
            }
        }

});

function showUserDetails() {

        if(userList.length == 0){
            idNameList.innerHTML = "<p class='text-muted'>No users are added yet, please add some users</p>";
        }else{
            let str = "<table class='table'>";
            str += "<thead>";
            str += "<tr>";
            str += "<th>#</th>";
            str += "<th>Name</th>";
            str += "<th>Action</th>";
            str += "</tr>";
            str += "</thead>";
            str += "<tbody>";
            userList.forEach((user, index) => {
                str += "<tr>";
                str += `<td>${index + 1}</td>`;
                str += `<td>${user}</td>`;
                str += `<td><i class="fa fa-edit" onclick="editUser('${user}')"></i>&nbsp;<i class="fa fa-trash" onclick="deleteUser('${user}')"></i></td>`;
                str += "</tr>";
            });
            str += "</tbody>";
            str += "</table>";
            idNameList.innerHTML = str;
        }
       
}

function editUser(userName) {
    document.querySelector("#idUserName").value = userName;
    isEditOn = true;
    index = userList.indexOf(userName);
}

function deleteUser(userName) {
    
    let index = userList.indexOf(userName);
    userList.splice(index, 1);
    showUserDetails();

}
