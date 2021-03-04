<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Add train</title>
</head>

<body>
    <h1>Add train</h1>
    <div class="container">

        <form action="indexBookTrain" id="myfromAdd" method="post">
            <div class="form-group">
                <label for="bookNumber">Book number</label>
                <input type="text" class="form-control" name="bookNumber" id="bookNumber" placeholder="Book Train">
            </div>
            <div class="form-group">
                <label for="currentTrain">Current train</label>
                <select name='currentTrain' id="currentTrain" class='form-control'>

                </select>
            </div>
            <div class="form-group">
                <label for="numberPlaces">Number places</label>
                <input type="number" class="form-control" name="numberPlaces" id="numberPlaces" placeholder="Number places">
            </div>
            <button type="submit" class="btn btn-primary" onclick="addBookTrain()">Submit</button>
        </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="bookTrain.js"></script>

</body>

</html>