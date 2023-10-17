Vue.createApp({
    data() {
        return {
            profileInfo: {},
            errorToats: null,
            errorMsg: null,
        }
    },
    methods: {
            getData: function () {
                axios.get("/api/professionals/current")
                    .then((response) => {
                    this.profileInfo = response.data;
                    })
                    .catch((error) => {
                        // handle error
                        this.errorMsg = "Error getting data";
                        this.errorToats.show();
                    })
            },
            formatDate: function (date) {
                return new Date(date).toLocaleDateString('en-gb');
            },
            signOut: function () {
                axios.post('/api/logout')
                    .then(response => window.location.href = "/web/index.html")
                    .catch(() => {
                        this.errorMsg = "Sign out failed"
                        this.errorToats.show();
                    })
            },
        },
        mounted: function () {
            this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
            this.getData();
        }
    }).mount('#app')