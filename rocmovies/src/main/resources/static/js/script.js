var select = document.getElementById("movie-style");
select.addEventListener("change", function(){
    console.log(select.value);

    href = "http://127.0.0.1:9090/rocmovies/movie?style=" + select.value;

    if(select.value != null){
        //window.location = href
    }
});