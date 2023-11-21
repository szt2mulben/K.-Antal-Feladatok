window.onload = function () {
    loadData();
};

function saveData() {
    var storageType = document.getElementById("storageSelector").value;
    var key = document.getElementById("key").value;
    var value = document.getElementById("value").value;

    if (key && value) {
        var data = {
            key: key,
            value: value
        };

        var jsonData = JSON.stringify(data);
        if (storageType === "local") {
            localStorage.setItem(key, jsonData);
        } else {
            sessionStorage.setItem(key, jsonData);
        }
        loadData();
    } else {
        alert("Kérlek add meg a key és value értékeket!");
    }
}

function loadData() {
    var outputDiv = document.getElementById("output");
    outputDiv.innerHTML = "";
    for (var i = 0; i < localStorage.length; i++) {
        var key = localStorage.key(i);
        var data = localStorage.getItem(key);
        var parsedData = JSON.parse(data);
        outputDiv.innerHTML += "Key: " + parsedData.key + ", Value: " + parsedData.value + " (Local Storage)<br>";
    }
    for (var i = 0; i < sessionStorage.length; i++) {
        var key = sessionStorage.key(i);
        var data = sessionStorage.getItem(key);
        var parsedData = JSON.parse(data);
        outputDiv.innerHTML += "Key: " + parsedData.key + ", Value: " + parsedData.value + " (Session Storage)<br>";
    }
    if (outputDiv.innerHTML === "") {
        outputDiv.innerHTML = "Adat nem érhető el.";
    }
}
function clearLocalStorage() {
    localStorage.clear();
    loadData();
}
function clearSessionStorage() {
    sessionStorage.clear();
    loadData();
}
