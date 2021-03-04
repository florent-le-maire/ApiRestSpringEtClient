function getAllTrains() {
    // $.get( "http://localhost:9191/trains", function( data ) {
    //     console.log(data);

    //   });
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type: "GET",
        url: "http://localhost:9191/trains"
    }).done(function (data) {
        // console.log(data[0].heureDepart);
        var div = document.getElementsByClassName("tableauTrains");
        $("table tbody").empty();
        Object.values(data).forEach(element => {
            let t = "";
            // t = '<tr> <th scope="row">' + element.numTrain + '</th> <td>' + element.villeDepart + '</td> <td>' + element.villeArrivee + '</td> <td>' + element.heureDepart + '</td> <td> <a href="updateTrain?id=' + element.numTrain + '" class="btn btn-primary">Edit</a> </td> <td> <form> <button type="submit" class="btn btn-danger" >Delete</button> </form> </td> </tr>';
            t = '<tr> <th scope="row">' + element.numTrain + '</th> <td>' + element.villeDepart + '</td> <td>' + element.villeArrivee + '</td> <td>' + element.heureDepart + '</td> <td> <a href="updateTrain?id=' + element.numTrain + '" class="btn btn-primary">Edit</a> </td> <td> <button type="submit" class="btn btn-danger" onclick="deleteTrain(`' + element.numTrain + '`)" >Delete</button> </td> </tr>';
            $("table tbody").append(t);

        });

    });
}
function updateTrain() {
    var fd = new FormData();
    fd.append('numTrain', $("#numTrain").val());
    fd.append('villeDepart', $("#villeDepart").val());
    fd.append('villeArrivee', $("#villeArrivee").val());
    fd.append('heureDepart', $("#heureDepart").val());
    let data = { 'numTrain': $("#numTrain").val(), 'villeDepart': $("#villeDepart").val(), 'villeArrivee': $("#villeArrivee").val(), 'heureDepart': $("#heureDepart").val() }
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type: "PUT",
        url: "http://localhost:9191/updatetrain",
        contentType: 'application/json',
        data: JSON.stringify(data),
    }).done(function (data) {
        console.log(data);
    });
    $("#myform").submit();

}
function deleteTrain(id) {
    console.log(id);
    $.ajax({
        url: 'http://localhost:9191/deletetrain/' + id,
        type: 'DELETE',
        success: function (result) {
            console.log(result);
            // Do something with the result
        }
    });
    location.reload();

}
function addTrain() {
    let data = { 'numTrain': $("#numTrain").val(), 'villeDepart': $("#villeDepart").val(), 'villeArrivee': $("#villeArrivee").val(), 'heureDepart': $("#heureDepart").val() };
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type: "POST",
        url: "http://localhost:9191/addtrain",
        contentType: 'application/json',
        data: JSON.stringify(data),
    }).done(function (data) {
        console.log(data);
    });
    $("#myfromAdd").submit();

}

getAllTrains();
// $("table tbody").append("<tr>");
// $("table tbody").append("<th scope='row'>", element.numTrain, "</th>");
// $("table tbody").append("<th>", element.villeDepart, "</th>");
// $("table tbody").append("<th>", element.villeArrivee, "</th>");
// $("table tbody").append("<th>", element.heureDepart, "</th>");
// $("table tbody").append("<td>", '<a href="" class="btn btn-primary">Edit</a>', "<td>");
// $("table tbody").append("<td>", '<a href="" class="btn btn-danger">Delete</a>', "<td>");
// $("table tbody").append("</tr>");