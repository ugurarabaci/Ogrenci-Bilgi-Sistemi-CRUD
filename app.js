const table=document.getElementById("userTable");

function getJsonFile(){
    fetch("http://localhost:8080/ogrenci/getAll")
    .then(response => response.json())
    .then(data=>{
        for(ogrenciler of data){
            console.log(ogrenciler);
            table.innerHTML+=`
            <tr>
            <td><label for="name">${ogrenciler.id}</label></td>
            <td><label for="name">${ogrenciler.number}</label></td>
            <td><label for="name">${ogrenciler.name}</label></td>
            <td>
            <a href="" class="btn btn-warning">Güncelle</a>
            <a href="" class="btn btn-danger" onClick="deleteUser(${ogrenciler.id})">Sil</a>
            </td>
        </tr>`
        }
    })
    .catch(err=>console.log(err));
}
getJsonFile();

function refreshTable(){
    getJsonFile();
}

function createUser(){
    let data={
        id:document.getElementById("id").value || "null",
        number:document.getElementById("number").value|| "null",
        name:document.getElementById("name").value|| "null",

    };
    fetch("http://localhost:8080/ogrenci/insert",{
        method:"POST",
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data=>{
        for(ogrenciler of data){
            console.log(ogrenciler);
            table.innerHTML+=`
            <tr>
            <td><label for="name">${ogrenciler.id}</label></td>
            <td><label for="name">${ogrenciler.number}</label></td>
            <td><label for="name">${ogrenciler.name}</label></td>
            <td>
            <a href="" class="btn btn-warning">Güncelle</a>
            <a href="" class="btn btn-danger" onClick="deleteUser(${ogrenciler.id})">Sil</a>
            </td>
        </tr>`
        }
    }).catch(err=>console.log(err));
}