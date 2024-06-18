```java
body {
    font-family: Arial, sans-serif;
    margin: 0;
    display: flex;
    height: 100vh;
}

.sidebar {
    width: 250px;
    background-color: #d3d3d3;
    padding: 20px;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
}

.sidebar .logo {
    text-align: center;
    margin-bottom: 20px;
}

.sidebar .user-info {
    text-align: center;
    margin-bottom: 40px;
}

.sidebar .user-info img {
    width: 60px;
    border-radius: 50%;
}

.sidebar .user-info .username {
    font-weight: bold;
}

.sidebar .menu {
    list-style: none;
    padding: 0;
}

.sidebar .menu li {
    margin-bottom: 20px;
}

.sidebar .menu li a {
    text-decoration: none;
    color: black;
    font-weight: bold;
    display: flex;
    align-items: center;
}

.sidebar .menu li a img {
    width: 20px;
    margin-right: 10px;
}

.sidebar .menu li:hover {
    background-color: white;
    padding: 10px;
    border-radius: 5px;
}

.content {
    flex-grow: 1;
    padding: 20px;
}

.search-bar {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
}

.search-bar input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px 0 0 5px;
    outline: none;
}

.search-bar button {
    padding: 10px;
    border: 1px solid #ccc;
    border-left: none;
    border-radius: 0 5px 5px 0;
    background-color: white;
    cursor: pointer;
}

.search-bar button:hover {
    background-color: rgb(75, 114, 205);
    padding: 10px;
    border-radius: 5px;
}

.search-bar button img {
    width: 20px;
}

.table-container {
    background-color: #f9f9f9;
    border-radius: 5px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.table-wrapper {
    max-height: 400px;
    /* Adjust height as needed */
    overflow-y: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table th,
table td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ccc;
}

table th {
    background-color: #e0e0e0;
}

table tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tr:hover {
    background-color: #ddd;
}

.status img {
    width: 20px;
    cursor: pointer;
}

.confirm-icon {
    background-color: #5cb85c;
    border-radius: 5px;
    padding: 5px;
}

.reject-icon {
    background-color: #d9534f;
    border-radius: 5px;
    padding: 5px;
}
