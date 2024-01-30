document.getElementById('filePicker').addEventListener('change', handleFileSelect);
document.getElementById('saveButton').addEventListener('click', saveText);

function handleFileSelect(event) {
    const file = event.target.files[0];
    const filename = file.name.slice(0, file.name.indexOf(".txt"));
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('textEditor').value = e.target.result;
        };
        reader.readAsText(file);
    }
    if (document.getElementById('textEditor').value == "") {
        localStorage.setItem('fileName', filename);
        saveText(); 
    }
}

function saveText() {
    const fileName = localStorage.getItem('fileName');

    if (fileName) {
        const textToSave = document.getElementById('textEditor').value;

        if (textToSave != "") {
            const link = document.createElement("a");
            const binarisadat = new Blob([textToSave], { type: 'text/plain' });
            link.href = URL.createObjectURL(binarisadat);
            link.download = fileName + "(szerk.).txt";
            link.click();
            URL.revokeObjectURL(link.href);
        }
    }
}
