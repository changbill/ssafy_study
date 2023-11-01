const app = Vue.createApp({
    data() {
        return {
            url: 'http://www.naver.com',
            showBooks: true,
            books: [
                { title: 'hello', author: 'chang', img: '', isFav: true},
                { title: 'nihao', author: 'wang', img: '', isFav: false},
                { title: 'konichiwa', author: 'yoshi', img: '', isFav: true},
            ]
        }
    },
    methods: {
        toggleShowBooks() {
            this.showBooks = !this.showBooks
        },
        toggleFav(book) {
            book.isFav = !book.isFav
        }
    },
    computed: {
        filteredBooks() { 
            this.books.filter((book) => book.isFav)
        }
    }
})

app.mount("#app");