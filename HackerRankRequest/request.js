const https = require('https');

function getMovieTitles(substr) {
    const currentPage = 1;

    https.get(`https://jsonmock.hackerrank.com/api/movies/search/?Title=${substr}&page=${currentPage}`, (res) => {
        res.setEncoding("utf8");
        res.on("data", function (body) {
            const parsed = JSON.parse(body);
            const movies = parsed.data;
            const totalPages = parsed.total_pages;
            const titles = [];
            movies.map((a) => {
                titles.push(a.Title);
            });

            if (totalPages >= 2) {
                for (let i = 2; i <= totalPages; i++) {
                    const url = `https://jsonmock.hackerrank.com/api/movies/search/?Title=${substr}&page=${i}`;
                    https.get(url, (res) => {
                        res.setEncoding("utf8");
                        res.on("data", function (body) {
                            const newData = JSON.parse(body);
                            const newMovies = newData.data;

                            newMovies.map((a) => {
                                titles.push(a.Title);
                            });

                            titles.sort().forEach((title) => console.log(title));
                        });
                    });
                }
            } else {
                titles.sort().forEach((title) => console.log(title));
            }
        });
    });
}

getMovieTitles("spiderman");
