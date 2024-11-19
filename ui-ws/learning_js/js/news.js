

const category = ["business","entertainment","general","health","science","sports","technology"];

const countryMap = [
       
        {
            "country": "USA",
            "code": "us"
        },
        {
            "country": "Australia",
            "code": "au"
        },
        {
            "country": "England",
            "code": "gb"
        },
      
        {
            "country": "India",
            "code": "in"
        },
        {
            "country": "Canada",
            "code": "ca"
        }

]

showFilterOptions();

api_key = "b968754c2b9a45d4bc54f5793806f40a";

function showFilterOptions() {

        let str = `<select class='form-control' id='idCategory'  onchange="getAndShowHeadings()">`;
        str += "<option value='general' selected>GENERAL</option>";
        category.forEach((cat) => {
            str += "<option value='"+cat+"'>"+cat.toUpperCase()+"</option>";
        });

        str += "</select>";

        let strCountry = `<select class='form-control' id='idCountry' onchange="getAndShowHeadings()">`;
        strCountry += "<option value='us' selected>USA</option>";
        countryMap.forEach((country) => {
            strCountry += "<option value='"+country.code+"'>"+country.country.toUpperCase()+"</option>";
        });

        strCountry += "</select>";

        document.querySelector("#idCategoryFilter").innerHTML = str ;
        document.querySelector("#idCountryFilter").innerHTML = strCountry;

}



function getAndShowHeadings(){

        let category = document.querySelector("#idCategory").value;
        let country = document.querySelector("#idCountry").value;

        let url = `https://newsapi.org/v2/top-headlines?country=${country}&apiKey=${api_key}&category=${category}`;    
        fetch(url).then((response) => {
            return response.json();
        }).then((data) => {
            let articles = data.articles;
            let str = "";
            articles.forEach((article, index) => {
                str += "<div class='card'>";
                str += "<div class='card-header'>";
                str += "<h5>"+article.title+"</h5>";
                str += "</div>";
                str += "<div class='card-body'>";
                str += "<img src='"+article.urlToImage+"' class='img-fluid'>";
                str += "<p>"+article.description+"</p>";
                str += "<a href='"+article.url+"' class='btn btn-primary'>Read More</a>";
                str += "</div>";
                str += "</div>";
            });
            document.querySelector("#idShowNewsItesms").innerHTML = str;
        }).catch((error) => {
            console.log(error);
        }
    );
}

