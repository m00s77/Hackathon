
function onSuccess(response) {

    alert(response);

}

function errorCallback(request, status, error) {

    console.log(error);

}

$(function () {
    $("#button1").click(postRegister(event));
    event.preventDefault();
});


function postRegister() {

    var data = {
        nickname: $('#nickname').val(),
        password: $('#password').val(),
        email: $('#email').val()
    }

    $.ajax({
        url: 'http://192.168.2.24:8080/BlackPennies/user/add',
        type: 'POST',
        data: JSON.stringify({
            nickname: data.nickname,
            password: data.password,
            email: data.email
        }),
        async: true,
        contentType: 'application/json',
        success: onSuccess,
        error: errorCallback
    });
}



