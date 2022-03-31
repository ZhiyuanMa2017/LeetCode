import React, {Component} from 'react';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            taken: false,
        };
    }

    checkLength = () => {
        if (this.state.username.length !== 0 && this.state.username.length < 4) {
            return "Username must be at least 4 characters long";
        }
    }

    checkUnique = () => {
        if (this.state.taken) {
            return "Username is not unique."
        }
    }

    checkUniqueFromUrl() {
        console.log(this.state.username);
        fetch(`https://hxj1tck8l1.execute-api.us-east-1.amazonaws.com/default/users/taken?username=${this.state.username}`)
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({taken: result.taken});
                }
            )
    }

    handleChange(event) {
        this.setState({username: event.target.value});
        if (this.state.username.length >= 4) {
            this.checkUniqueFromUrl();
        }
    }

    render = () => {
        return (
            <div>
                <h1>Username Input</h1>
                <input
                    type="text" id="username"
                    value={this.state.username}
                    onChange={event => {
                        this.handleChange(event)
                    }}/>
                <div>
                    <p> {this.checkLength()} </p>
                    <p> {this.checkUnique()} </p>
                </div>
            </div>
        )
    }

}

export default App;
