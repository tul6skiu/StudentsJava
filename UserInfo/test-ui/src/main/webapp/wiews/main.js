function disp() {

    getImageName()
}

var getImageName = function() {
    document.onclick = function(e) {
        console.log(e.target.tagName);
        if (e.target.tagName == 'BUTTON') {
            var value = e.target.getAttribute("value");
            let newform = document.getElementById(value)
            if (newform.style.display == "none") {
                newform.style.display = "block";
            }
        }
    }
}