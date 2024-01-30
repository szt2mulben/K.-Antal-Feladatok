document.getElementById('filePicker').addEventListener('change', handleFileSelect);
document.getElementById('saveButton').addEventListener('click', saveText);

function handleFileSelect(event) {
const file = event.target.files[0];
console.log(file.name.slice(0, file.name.indexOf(".txt")))
const filename = file.name.slice(0, file.name.indexOf(".txt"));
    if (document.getElementById('textEditor').value != " ") {saveText(filename)}
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            document.getElementById('textEditor').value = e.target.result;
        };
        reader.readAsText(file);
    }
}

function saveText(fileS) {
const textToSave = document.getElementById('textEditor').value;
const link = document.createElement("a");
const binarisadat = new Blob([textToSave], {type: 'text/plain'});

link.href = URL.createObjectURL(binarisadat);
link.download = fileS+".txt";
link.click();
URL.revokeObjectURL(link.href);

}