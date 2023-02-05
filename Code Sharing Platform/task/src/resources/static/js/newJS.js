function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": document.getElementById("time_restriction").value,
        "views": document.getElementById("views_restriction").value
    };

    let jsonResponse = null;
    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status === 200 && jsonResponse != null) {
        console.log(jsonResponse);
        alert("Success! Snippet ID: " + jsonResponse.id);
    } else {
        console.log(jsonResponse);
        alert("Failed to post the snippet. Reason: " + jsonResponse.message);
    }
}