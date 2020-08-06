$(document).ready(function() {

    postRegister();
    getUser();

  });







//add user authenticated

function getUser(){

    var id = $('#nickname')
    console.log(id);


}


function postRegister() {
    
    $.ajax({
    url: 'http://192.168.2.24:8080/BlackPennies/user/',
    type: 'POST',
    data: JSON.stringify({
        nickname: $('nickname'),
        password: btoa($('password')),
        email: $('email')
    }),
    async: true,
    contentType: 'application/json',
    success: onSucess,
    error: errorCallback
});
}

  
  