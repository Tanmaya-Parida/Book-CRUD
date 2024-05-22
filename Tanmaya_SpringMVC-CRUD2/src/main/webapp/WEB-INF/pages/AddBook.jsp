<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>BMS-Add Book</title>
    <style>
        /* Navbar */
        .navbar {
            background-color: #343a40; /* Dark background color for the navbar */
        }

        .navbar-brand {
            color: #ffffff; /* White text color for navbar brand */
        }

        .nav-link {
            color: #ffffff; /* White text color for navbar links */
        }

        /* Card */
        .card {
            margin-top: 20px; /* Add some top margin to the card */
            border: 1px solid #ccc; /* Light gray border around the card */
            border-radius: 5px; /* Rounded corners for the card */
        }

        .card-header {
            background-color: #007bff; /* Blue background color for card header */
            color: #ffffff; /* White text color for card header */
        }

        .card-body {
            padding: 20px; /* Add padding inside the card body */
        }

        .form-label {
            font-weight: bold; /* Make form labels bold */
        }

        .btn-primary {
            background-color: #007bff; /* Blue background color for primary button */
            border-color: #007bff; /* Blue border color for primary button */
        }

        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue background color on hover */
            border-color: #0056b3; /* Darker blue border color on hover */
        }

        /* Body */
        body {
            background-color: #f8f9fa; /* Light gray background color for the body */
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">BMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" aria-current="page" href="home">Home</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#">Add</a></li>
                    <li class="nav-item"><a class="nav-link" href="getAll">All</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <div class="card border-info mb-3">
        <div class="card-header">Please fill out the form and click on Save.</div>
        <div class="card-body">
            <form action="save" method="POST">
                <div class="mb-3"></div>
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" id="author" name="author" required>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Price</label> 
                    <input type="number" class="form-control" id="price" name="price" required>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
