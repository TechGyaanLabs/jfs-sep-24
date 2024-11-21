const baseURL = 'https://ipl-stats-server-app.onrender.com/v1/contact';


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
    if(contacts.length === 0){
        contactList.innerHTML = "<h3>No Contacts Found</h3>";
        return;
    }
    contactList.innerHTML = '';
    let str = "<table border='1' class='table table-striped'><thead><tr><th>Name</th><th>Phone</th><th>Email</th><th>Edit</th><th>Delete</th></tr></thead>";
    str += "<tbody>"
    contacts.forEach(contact => {
        str += `<tr><td>${contact.name}</td><td>${contact.mobile}</td><td>${contact.email}</td><td><button class='btn btn-primary' onclick='editContact(${JSON.stringify(contact)})'>Edit</button></td><td><button class='btn btn-primary' onclick='deleteContact(${JSON.stringify(contact)})'>Delete</button></td></tr>`;
    });
    str += "</tbody>";
    str += "</table>";
    contactList.innerHTML = str;
}

const idContactForm = document.getElementById('idContactForm');
const idAddContact = document.getElementById('idAddContact');
const idUpdateContact = document.getElementById('idUpdateContact');
const idSearchName = document.getElementById('idSearchName');

idContactForm.addEventListener('submit', function(event){
    event.preventDefault();
    addContact();
    idContactForm.reset();
});

idUpdateContact.addEventListener('click', function(event){
    event.preventDefault();
    updateContact();
    idContactForm.reset();
});


function updateContact(){
    let name = document.getElementById('idName').value;
    let mobile = document.getElementById('idPhone').value;
    let email = document.getElementById('idEmail').value;
    let id = document.getElementById('idContactId').value

    let contact = {
        id: id,
        name: name,
        mobile: mobile,
        email: email
    };

    fetch(`${baseURL}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    }).then(response => {
        return response.json();
    }).then(data=>{
        fetchContactsAndShow();
        idAddContact.style.display = 'block';
        idUpdateContact.style.display = 'none';
    }).catch(error=>{
        console.log(error);
    });
}

function addContact(){
    let name = document.getElementById('idName').value;
    let mobile = document.getElementById('idPhone').value;
    let email = document.getElementById('idEmail').value;

    let contact = {
        name: name,
        mobile: mobile,
        email: email
    };

    fetch(`${baseURL}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    }).then(response => {
        return response.json();
    }).then(data=>{
        fetchContactsAndShow();
    }).catch(error=>{
        console.log(error);
    });


}

function editContact(contact){
    document.getElementById('idName').value = contact.name;
    document.getElementById('idPhone').value = contact.mobile;
    document.getElementById('idEmail').value = contact.email;
    document.getElementById('idContactId').value = contact.id;
    idAddContact.style.display = 'none';
    idUpdateContact.style.display = 'block';
}

function deleteContact(contact){
   let res = confirm(`Are you sure to delete ${contact.name} contact ?`);
   if(res){
         fetch(`${baseURL}/${contact.id}`, {
              method: 'DELETE'
         }).then(response => {
              return response.json();
         }).then(data=>{
              fetchContactsAndShow();
         }).catch(error=>{
              console.log(error);
         });
   }else{
         return;
   }
}

idSearchName.addEventListener('keyup', function(event){
    let searchName = idSearchName.value;
    if(searchName.length === 0){
        fetchContactsAndShow();
        return;
    }
    fetch(`${baseURL}/search/${searchName}`).then(response => {
        return response.json();
    }).then(contacts=>{
        showContacts(contacts);
    }).catch(error=>{
        console.log(error);
    });
});

fetchContactsAndShow();