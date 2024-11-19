const baseURL = 'http://localhost:8080/v1/contact';


function fetchContactsAndShow(){

    fetch(`${baseURL}/all`).then(response => {
        return response.json();
    }).then(data=>{
        showContacts(data);
    }).catch(error=>{
        console.log(error);
    });
}

function showContacts(contacts){

    let contactList = document.getElementById('contactList');
    contactList.innerHTML = '';
    let str = "<table border='1' class='table table-striped'><thead><tr><th>Name</th><th>Phone</th><th>Email</th><th>Edit</th><th>Delete</th></tr></thead>";
    str += "<tbody>"
    contacts.forEach(contact => {
        str += `<tr><td>${contact.name}</td><td>${contact.mobile}</td><td>${contact.email}</td><td><button class='btn btn-primary' onclick='editContact(${contact.id})'>Edit</button></td><td><button class='btn btn-primary' onclick='deleteContact(${contact.id})'>Delete</button></td></tr>`;
    });
    str += "</tbody>";
    str += "</table>";
    contactList.innerHTML = str;
}

fetchContactsAndShow();