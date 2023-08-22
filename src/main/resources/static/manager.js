Vue.createApp({
    data() {
        return {
            email: "",
            firstName: "",
            lastName: "",
            password: "",
            outPut: "",
            professionals: []
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        // load and display JSON sent by server for /clients
        loadData() {
            axios.get("/professionals")
                .then((response) => {
                    // handle success
                    this.outPut = response.data;
                    this.professional = response.data._embedded.professionals;
                })
                .catch((error) => {
                    alert("Error loading professional: " + error)
                })
        },
        // handler for when user clicks add client
        addProfessional() {
            if (this.email.length > 1 && this.firstName.length > 1 && this.lastName.length > 1) {
                this.postProfessional(this.email, this.firstName, this.lastName);
            }
        },
        // code to post a new client using AJAX
        // on success, reload and display the updated data from the server
        postProfessional(email, firstName, lastName) {
            axios.post("/professionals", { "email": email, "firstName": firstName, "lastName": lastName })
                .then((response) => {
                    // handle success
                    this.loadData();
                    this.clearData();
                })
                .catch((error) => {
                    // handle error
                    alert("Error to create professional: " + error)
                })
        },
        clearData() {
            this.firstName = "";
            this.lastName = "";
            this.email = "";
            this.password = "";
        }
    }
}).mount("#app");