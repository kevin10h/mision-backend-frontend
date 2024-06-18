```java
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitud de Herramienta</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="sidebar">
        <div class="logo">
            <h2>Empresa Topitop S.A</h2>
        </div>
        <div class="user-info">
            <img src="user-icon.png" alt="User Icon">
            <p class="username">Usuario: Operario</p>
        </div>
        <ul class="menu">
            <li class="cls1">
                <a href="#"><img src="home-icon.png" alt="Home Icon"> Datos personales</a>
            </li>
            <li class="cls2">
                <a href="#"><img src="tool-icon.png" alt="Tool Icon"> Solicitar herramienta</a>
            </li>
            <li class="cls3">
                <a href="#"><img src="activity-icon.png" alt="Activity Icon"> Registro de actividades</a>
            </li>
            <li class="cls4">
                <a href="#"><img src="complaint-icon.png" alt="Complaint Icon"> Quejas y reclamos</a>
            </li>
        </ul>
    </div>
    <div class="content">
        <div class="search-bar">
            <input type="text" placeholder="Buscar por código">
            <input type="text" placeholder="Buscar por nombre">
            <button>Buscar</button>
        </div>
        <div class="table-container">
            <h2>Listado de herramientas</h2>
            <table>
                <thead>
                    <tr>
                        <th>Código Herramienta</th>
                        <th>Herramienta</th>
                        <th>Modelo</th>
                        <th>Proveedor</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>HE029</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><button class="btn">Enviar solicitud</button></td>
                    </tr>
                    <tr>
                        <td>HE029</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Dyeing Techno Inc.</td>
                        <td><button class="btn">Enviar solicitud</button></td>
                    </tr>
                    <tr>
                        <td>HE029</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><button class="btn">Enviar solicitud</button></td>
                    </tr>
                    <tr>
                        <td>HE029</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Dyeing Techno Inc.</td>
                        <td><button class="btn">Enviar solicitud</button></td>
                    </tr>
                    <tr>
                        <td>HE029</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><button class="btn">Enviar solicitud</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>
