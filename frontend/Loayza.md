### html pagina principal
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <title>Empresa Topitop S.A.</title>
    <link rel="stylesheet" type="text/css" href="body.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>

<body>
    <div id="sidebar">
        <div class="header">
            <h1>Empresa Topitop S.A.</h1>
            <button class="close-btn">&times;</button>
        </div>
        <div class="user-info">
            <img src="user-icon.png" alt="User Icon" class="user-icon">
            <p>Usuario : <strong>Gestor de Produccion</strong></p>
        </div>
        <ul>
            <li class="                                                                     "><i class="fas fa-home"></i>Datos personales</li>
            <li class="cls2"><i class="fas fa-tools"></i>Solicitud de herramienta</li>
            <li class="cls3"><i class="fas fa-box"></i>Solicitud de pedido</li>
            <li class="cls4"><i class="fas fa-check-circle"></i>Registro de calidad</li>
            <li class="cls5"><i class="fas fa-tasks"></i>Actividades</li>
            <li class="cls6"><i class="fas fa-chart-line"></i>Reportes</li>
            <li class="cls7"><i class="fas fa-comments"></i>Quejas y reclamos</li>
        </ul>

    </div>
    <div id="main-content"></div>
</body>

</html>

### CSS DE LA PAGINA PRINCIPAL(nombrar al archivo body.css)
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0 px;
    display: flex;
    /*background-color: #007BFF;*/
    background-image: url('logo.png');
    background-repeat: no-repeat;
    background-size: cover;
}

#sidebar {
    width: 20%;
    background-color: #c7bebd;
    color: rgb(0, 0, 0);
    padding: 20px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100vh;
}

.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header .close-btn {
    background: none;
    border: none;
    font-size: 24px;
    cursor: pointer;
}

.user-info {
    text-align: center;
    margin-bottom: 20px;
}

.user-info .user-icon {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    margin-bottom: 15px;
}

#sidebar ul {
    list-style-type: none;
    padding: 0;
}

#sidebar ul li {
    padding: 10px 0;
    display: flex;
    align-items: center;
}

#sidebar ul li i {
    margin-right: 10px;
}

#sidebar ul li.cls1:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls2:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls3:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls4:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls5:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls6:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#sidebar ul li.cls7:hover {
    background-color: white;
    border-radius: 10px;
    margin-left: 10px;
}

#main-content {
    width: 80%;
    padding: 50px;
}


### html de mi modulo:
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Módulo de Calidad de Herramientas y Maquinarias</title>
    <link rel="stylesheet" href="estilo.css">
</head>

<body>
    <header>
        <nav>
            <ul>
                <li><a href="#mantenimiento">Mantenimiento</a></li>
                <li><a href="#inspecciones">Inspecciones</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="dashboard">
            <h1>Dashboard</h1>
            <div class="summary">
                <div class="card">Herramientas: 100</div>
                <div class="card">Próximas Inspecciones: 5</div>
                <div class="card">Próximos Mantenimientos: 3</div>
            </div>
        </section>

        <section id="mantenimiento">
            <h2>Mantenimiento Preventivo y Necesario</h2>
            <form>
                <label for="tipo_mantenimiento">Tipo de Mantenimiento:</label>
                <select id="tipo_mantenimiento" name="tipo_mantenimiento">
                    <option value="preventivo">Preventivo</option>
                    <option value="necesario">Necesario</option>
                </select>
                <label for="codigo_herramienta">Código de Herramienta:</label>
                <input type="text" id="codigo_herramienta" name="codigo_herramienta">
                <label for="fecha_registro">Fecha de Registro:</label>
                <input type="date" id="fecha_registro" name="fecha_registro">
                <label for="codigo_operario">Código de Operario:</label>
                <input type="text" id="codigo_operario" name="codigo_operario">
                <label for="descripcion">Descripción de lo ocurrido:</label>
                <textarea id="descripcion" name="descripcion"></textarea>
                <button type="submit">Guardar</button>
            </form>
            <div class="filtros">
                <label for="filtro_codigo_herramienta">Filtrar por Código de Herramienta:</label>
                <input type="text" id="filtro_codigo_herramienta">
                <label for="filtro_fecha_registro">Filtrar por Fecha de Registro:</label>
                <input type="date" id="filtro_fecha_registro">
                <button type="button" id="aplicar_filtros">Aplicar Filtros</button>
            </div>
            <h3>Mantenimiento Preventivo</h3>
            <table id="tabla_preventivo">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Código de Herramienta</th>
                        <th>Fecha de Registro</th>
                        <th>Código de Operario</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Preventivo</td>
                        <td>001</td>
                        <td>01/07/2024</td>
                        <td>OP123</td>
                        <td>Revisión periódica</td>
                    </tr>
                </tbody>
            </table>
            <h3>Mantenimiento Necesario</h3>
            <table id="tabla_necesario">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Código de Herramienta</th>
                        <th>Fecha de Registro</th>
                        <th>Código de Operario</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Necesario</td>
                        <td>002</td>
                        <td>02/07/2024</td>
                        <td>OP456</td>
                        <td>Reparación urgente</td>
                    </tr>
                </tbody>
            </table>
        </section>

        <section id="inspecciones">
            <h2>Inspecciones de Calidad</h2>
            <form>
                <label for="fecha_inspeccion">Fecha:</label>
                <input type="date" id="fecha_inspeccion" name="fecha_inspeccion">
                <label for="inspector">Inspector:</label>
                <input type="text" id="inspector" name="inspector">
                <label for="resultados">Resultados:</label>
                <textarea id="resultados" name="resultados"></textarea>
                <button type="submit">Guardar</button>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Inspector</th>
                        <th>Resultados</th>
                        <th>Observaciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>01/07/2024</td>
                        <td>Juan Pérez</td>
                        <td>Aprobado</td>
                        <td>Sin observaciones</td>
                    </tr>
                </tbody>
            </table>
        </section>
    </main>
</body>

</html>

### CSS DE mi modulo:

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f8f8f8;
}

header {
    background-color: #333;
    color: white;
    padding: 1em 0;
}

nav ul {
    list-style: none;
    padding: 0;
    display: flex;
    justify-content: center;
}

nav ul li {
    margin: 0 1em;
}

nav ul li a {
    color: white;
    text-decoration: none;
}

main {
    padding: 2em;
}

h1,
h2 {
    text-align: center;
}

.summary {
    display: flex;
    justify-content: space-around;
    margin-bottom: 2em;
}

.card {
    background-color: white;
    padding: 1em;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 30%;
}

form {
    background-color: white;
    padding: 1em;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 2em;
}

form label {
    display: block;
    margin: 0.5em 0 0.2em;
}

form input,
form select,
form textarea {
    width: 100%;
    padding: 0.5em;
    margin-bottom: 1em;
    border: 1px solid #ccc;
    border-radius: 4px;
}

form button {
    background-color: #333;
    color: white;
    padding: 0.5em 1em;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

form button:hover {
    background-color: #555;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 2em;
}

table,
th,
td {
    border: 1px solid #ccc;
}

table th,
table td {
    padding: 0.5em;
    text-align: left;
}

table th {
    background-color: #f2f2f2;
}

.filtros {
    margin-bottom: 2em;
}

.filtros label {
    display: inline-block;
    margin-right: 1em;
}

.filtros input {
    padding: 0.5em;
    margin-right: 1em;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.filtros button {
    background-color: #333;
    color: white;
    padding: 0.5em 1em;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.filtros button:hover {
    background-color: #555;
}

.calendar,
.report {
    background-color: white;
    padding: 1em;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    text-align: center;
}
