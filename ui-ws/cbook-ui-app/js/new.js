const countries = ['us', 'gb', 'in', 'ca', 'au'];
const categories = ['business', 'entertainment', 'general', 'health', 'science', 'sports', 'technology'];
const apiKey = "b968754c2b9a45d4bc54f5793806f40a";
const DEFAULT_COUNTRY = "us";
const DEFAULT_CATEGORY = "business";

function createSelect(options, id, defaultText) {
    return `
        <select class="form-select" id="${id}">
            <option value="">${defaultText}</option>
            ${options.map(option => `<option value="${option}">${option}</option>`).join('')}
        </select>
    `;
}

function showNewsCategoryAndCountry() {
    document.getElementById("idNewsCategory").innerHTML = createSelect(categories, "idCategory", "Select Category");
    document.getElementById("idNewsCountry").innerHTML = createSelect(countries, "idCountry", "Select Country");
    addEventListeners();
}

function addEventListeners() {
    ['idCategory', 'idCountry'].forEach(id => {
        document.getElementById(id).addEventListener('change', handleFilterChange);
    });
}

function handleFilterChange() {
    const selectedCountry = document.getElementById('idCountry').value || DEFAULT_COUNTRY;
    const selectedCategory = document.getElementById('idCategory').value || DEFAULT_CATEGORY;
    getNews(selectedCountry, selectedCategory);
}

async function getNews(country = DEFAULT_COUNTRY, category = DEFAULT_CATEGORY) {
    try {
        const url = `https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiKey}`;
        const response = await fetch(url);
        const { articles } = await response.json();
        displayNews(articles);
    } catch (error) {
        console.error('Error fetching news:', error);
        document.getElementById("idNewsContent").innerHTML = 
            '<div class="alert alert-danger">Error loading news</div>';
    }
}

function displayNews(articles) {
    const newsHtml = articles.map(article => `
        <div class="col-md-8 mb-4 offset-md-2">
            <div class="card h-100">
                ${article.urlToImage ? `<img src="${article.urlToImage}" class="card-img-top" alt="${article.title}">` : ''}
                <div class="card-body">
                    <h5 class="card-title">${article.title}</h5>
                    <p class="card-text">${article.description || ''}</p>
                    <p class="card-text">
                        <small class="text-muted">Published: ${new Date(article.publishedAt).toLocaleDateString()}</small>
                    </p>
                    <a href="${article.url}" target="_blank" class="btn btn-primary">Read More</a>
                </div>
            </div>
        </div>
    `).join('');
    
    document.getElementById("idNewsContent").innerHTML = `<div class="row">${newsHtml}</div>`;
}

showNewsCategoryAndCountry();
getNews();


