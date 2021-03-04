function getAllBookTrains() {
    // $.get( "http://localhost:9191/trains", function( data ) {
    //     console.log(data);

    //   });
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type: "GET",
        url: "http://localhost:9191/bookTrains"
    }).done(function (data) {
        // console.log(data[0].heureDepart);
        $("table tbody").empty();
        Object.values(data).forEach(element => {
            let t = "";
            console.log(element);
            // t = '<tr> <th scope="row">' + element.numTrain + '</th> <td>' + element.villeDepart + '</td> <td>' + element.villeArrivee + '</td> <td>' + element.heureDepart + '</td> <td> <a href="updateTrain?id=' + element.numTrain + '" class="btn btn-primary">Edit</a> </td> <td> <form> <button type="submit" class="btn btn-danger" >Delete</button> </form> </td> </tr>';
            t = '<tr> <th scope="row">' + element.bookNumber + '</th> <td>' + element.currentTrain.numTrain + '</td> <td>' + element.numberPlaces + '</td>  <td> <button type="submit" class="btn btn-danger" onclick="deleteBookTrain(`' + element.bookNumber + '`)" >Delete</button> </td> </tr>';
            $("table tbody").append(t);

        });

    });
}

function deleteBookTrain(id) {
    console.log(id);
    $.ajax({
        url: 'http://localhost:9191/deletebookTrain/' + id,
        type: 'DELETE',
        success: function (result) {
            console.log(result);
            // Do something with the result
        }
    });
    location.reload();

}
function addBookTrain() {
    let t = JSON.parse($("#currentTrain").val());
    let data = { 'bookNumber': $("#bookNumber").val(), 'currentTrain': t, 'numberPlaces': $("#numberPlaces").val() };
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type: "POST",
        url: "http://localhost:9191/addbookTrain",
        contentType: 'application/json',
        data: JSON.stringify(data),
    }).done(function (data) {
        console.log(data);
    });
    $("#myfromAdd").submit();

}
$.getJSON("http://localhost:9191/trains", function(data){
    Object.values(data).forEach(element => {
        var o = new Option(String(element.numTrain), '{ "numTrain": "'+element.numTrain+'", "villeDepart": "'+element.villeDepart+'", "villeArrivee": "'+element.villeArrivee+'", "heureDepart": "'+element.heureDepart+'" }');
        /// jquerify the DOM object 'o' so we can use the html method
        $(o).html(element.numTrain);
        $("#currentTrain").append(o);
    });
})
getAllBookTrains();
// $("table tbody").append("<tr>");
// $("table tbody").append("<th scope='row'>", element.numTrain, "</th>");
// $("table tbody").append("<th>", element.villeDepart, "</th>");
// $("table tbody").append("<th>", element.villeArrivee, "</th>");
// $("table tbody").append("<th>", element.heureDepart, "</th>");
// $("table tbody").append("<td>", '<a href="" class="btn btn-primary">Edit</a>', "<td>");
// $("table tbody").append("<td>", '<a href="" class="btn btn-danger">Delete</a>', "<td>");
// $("table tbody").append("</tr>");