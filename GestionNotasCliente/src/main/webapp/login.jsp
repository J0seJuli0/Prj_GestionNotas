<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - CompuStore</title>
    <!-- Enlace al CSS -->
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <style>
    
    /* Reset básico */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Estilo general */
body {
    font-family: 'Arial', sans-serif;
    background: #F8F9FA; /* Fondo blanco puro */
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #333;
}

/* Wrapper del formulario */
.wrapper {
    background: #fff;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: 100%;
    max-width: 400px;
    color: #333;
}

.logo-img {
    width: 100px; /* Ancho fijo */
    height: 100px; /* Alto fijo (igual que el ancho para que sea cuadrado) */
    border-radius: 50%; /* Hace que el contenedor sea circular */
    object-fit: cover; /* Ajusta la imagen para que llene el contenedor sin distorsión */
    border: 3px solid #1E90FF; /* Opcional: agrega un borde azul alrededor */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Opcional: agrega un pequeño sombreado */
    margin-bottom: 20px;
}



.logo-icon {
    font-size: 4rem;
    color: #1E90FF; /* Azul */
}

h1 {
    font-size: 1.5rem;
    color: #1E90FF; /* Azul */
    margin-bottom: 20px;
}

/* Campos del formulario */
.input-box {
    position: relative;
    margin: 15px 0;
    display: flex;
    align-items: center;
    background: #F8F9FA; /* Fondo claro para inputs */
    border: 2px solid #1E90FF; /* Azul */
    border-radius: 5px;
    padding: 10px;
}

.input-box input {
    width: 100%;
    border: none;
    outline: none;
    background: transparent;
    padding-left: 10px;
    font-size: 1rem;
    color: #333;
}

.input-box i {
    font-size: 1.2rem;
    color: #1E90FF; /* Azul */
}

.toggle-icon {
    cursor: pointer;
    margin-left: 10px;
}

/* Botón */
.btn {
    width: 100%;
    background: #FFD700; /* Amarillo */
    color: #fff;
    border: none;
    padding: 10px;
    font-size: 1rem;
    font-weight: bold;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.3s;
    margin-top: 20px;
}

.btn:hover {
    background: #FFC107; /* Amarillo más oscuro */
}
    
    
    </style>
    <script>
        // Función para mostrar u ocultar la contraseña
        function togglePassword() {
            var passwordField = document.getElementById('contrasena');
            var eyeIcon = document.getElementById('eye-icon');
            
            if (passwordField.type === 'password') {
                passwordField.type = 'text';
                eyeIcon.classList.remove('bxs-hide');
                eyeIcon.classList.add('bxs-show');
            } else {
                passwordField.type = 'password';
                eyeIcon.classList.remove('bxs-show');
                eyeIcon.classList.add('bxs-hide');
            }
        }
    </script>
</head>
<body>
    <div class="wrapper">
        <form action="LoginController" method="post">
            <!-- Icono principal -->
            <div class="logo">
                <img src="img/ImagenCole.jpg" alt="Logo de usuario" class="logo-img">
            </div>
            <!-- Título -->
            <h1>¿Tienes una cuenta?</h1>
            <!-- Campo Usuario -->
            <div class="input-box">
                <i class="bx bxs-user"></i>
                <input type="text" id="usuario" name="usuario" placeholder="Usuario" required>
            </div>
            <!-- Campo Contraseña -->
            <div class="input-box">
                <i class="bx bxs-lock-alt"></i>
                <input type="password" id="contrasena" name="contrasena" placeholder="Contraseña" required>
                <i class="bx bxs-hide toggle-icon" id="eye-icon" onclick="togglePassword()"></i>
            </div>
            <!-- Botón -->
            <button type="submit" class="btn">Ingresar</button>
        </form>
    </div>
</body>
</html>