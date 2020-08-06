$(document).ready(function() {
    populateUser(user);
    console.log(user);
    addFifty();
  });


var user = {
    id: 1,
    name: "Zezao",
    balance: 100
}


function populateUser(user) {

    var userTable = $('#user-table');
  
      var str;
  
  
      str = "<tr> <td>" + user.id + "</td>" +
            "<td>" + user.name + "</td>" +
            "<td id ='user-balance'>" + user.balance + "</td> </tr>"


      
      $(str).appendTo(userTable);
  
 }

 function addFifty() {

    $('#button').click(function () {
        user.balance += 50;
        //populateUser(user);
        console.log(user.balance);
        $('#user-balance').text(user.balance);

    } )

 }


