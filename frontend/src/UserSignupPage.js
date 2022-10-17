import React  from "react";

class UserSignupPage extends React.Component{

    state = {
        userName : null,
        displayName : null,
        password : null,
        passwordRepeat : null
    };

    onChange = event => {
        const field = event.target.name;
        const value = event.target.value;
        this.setState({
            [field]: value
        })
    }

    // onChangeUserName = event => {
    //     this.setState({
    //         userName: event.target.value
    //     })
    // };

    // onChangeDisplayName = event => {
    //     this.setState({
    //         displayName: event.target.value
    //     })
    // };

    // onChangePassword = event => {
    //     this.setState({
    //         displayName: event.target.value
    //     })
    // };

    // onChangePasswordRepeat = event => {
    //     this.setState({
    //         displayName: event.target.value
    //     })
    // };

    render(){
        return(
            <form>
                <h1>Sign Up</h1>
                <div>
                    <label>Username</label>
                    <input name="userName" onChange={this.onChange} />
                </div>
                <div>
                    <label>Display Name</label>
                    <input name="displayName" onChange={this.onChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type="password" onChange={this.onChange} />
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input name="passwordRepeat" type="password" onChange={this.onChange} />
                </div>
                <button>Sign Up</button>
            </form>
        );
    }

}

export default UserSignupPage;
