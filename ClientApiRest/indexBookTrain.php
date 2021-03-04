<?php
header('Access-Control-Allow-Origin: *');
?>
<!doctype html>
<html lang="en">

<head>
    <httpProtocol>
        <customHeaders>
            <add name="Access-Control-Allow-Origin" value="*" />
            <add name="Access-Control-Allow-Headers" value="Content-Type" />
            <add name="Access-Control-Allow-Methods" value="GET, POST, PUT, DELETE, OPTIONS" />
        </customHeaders>
    </httpProtocol>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>TestApi Rest</title>
</head>

<body>
    <h1>Client api rest train</h1>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="http://localhost/TestPerso/ClientApiRest/">List des trains</a></li>
            <li class="breadcrumb-item"><a href="http://localhost/TestPerso/ClientApiRest/indexBookTrain">List des bookings</a></li>
        </ol>
    </nav>

    <div class="container">
        <form action="ajouterBookTrain" method="post">
            <button type="submit" class="btn btn-primary">Ajouter un booktrain</button>
        </form>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">bookNumber</th>
                    <th scope="col">currentTrain</th>
                    <th scope="col">numberPlaces</th>
                    <td scope="col" colspan=1>Actions</td>
                </tr>
            </thead>
            <tbody>
                <tr>

                </tr>
            </tbody>
        </table>

    </div>
    <!-- <input type="button" value="ttttt" onclick="getAllTrains()"> -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="bookTrain.js"></script>
</body>

</html>