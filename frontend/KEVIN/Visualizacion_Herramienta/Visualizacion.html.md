```java
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Información de Solicitud</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="sidebar">
        <div class="logo">
            <h2>Empresa Topitop S.A</h2>
        </div>
        <div class="user-info">
            <img src="user-icon.png" alt="User Icon">
            <p class="username">Usuario : Operario</p>
        </div>
        <ul class="menu">
            <li>
                <a href="#"><img src="data-icon.png" alt="Home Icon"> datos personales</a>
            </li>
            <li>
                <a href="#"><img src="info-icon.png" alt="Info Icon"> información de solicitud</a>
            </li>
            <li>
                <a href="#"><img src="tool-icon.png" alt="Tool Icon"> solicitar herramienta</a>
            </li>
            <li>
                <a href="#"><img src="activity-icon.png" alt="Activity Icon"> registro de actividades</a>
            </li>
            <li>
                <a href="#"><img src="complaint-icon.png" alt="Complaint Icon"> quejas y reclamos</a>
            </li>
        </ul>
    </div>
    <div class="content">
        <div class="table-container">
            <h2>Listado de solicitudes generados</h2>
            <table>
                <thead>
                    <tr>
                        <th>fecha de solicitud</th>
                        <th>Herramienta</th>
                        <th>Modelo</th>
                        <th>Proveedor</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>10A</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><span class="status pending">PENDIENTE</span></td>
                    </tr>
                    <tr>
                        <td>10A</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Dyeing Techno Inc.</td>
                        <td><span class="status pending">PENDIENTE</span></td>
                    </tr>
                    <tr>
                        <td>08A</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><span class="status approved">APROBADA</span></td>
                    </tr>
                    <tr>
                        <td>08A</td>
                        <td>Máquina de teñido</td>
                        <td>DyeMax Pro Ultra</td>
                        <td>Weaving Machines Co.</td>
                        <td><span class="status approved">APROBADA</span></td>
                    </tr>
                    <tr>
                        <td>10A</td>
                        <td>Máquina de planchado</td>
                        <td>DyeMax Pro</td>
                        <td>Dyeing Techno Inc.</td>
                        <td><span class="status rejected">RECHAZADA</span></td>
                    </tr>
                    <tr>
                        <td>10A</td>
                        <td>Máquina de bordar</td>
                        <td>LaserCut Pro 3000</td>
                        <td>Dyeing Techno Inc.</td>
                        <td><span class="status approved">APROBADA</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>
