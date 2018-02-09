class UserForm extends React.Component {
	render() {
	return(
				<div className="one-half column">
					<h3>Insert a new message: </h3>
					<form>
						<input type="text" name="user" />
						<input type="text" name="msg" /> 
						<input type="submit" value="Submit Message" />
					</form>
				</div>	
		);
}
}

class MessageBoard extends React.Component {
	render () {
	return (
			<div className="one-third column">
				<h3>Message Board: </h3>
				<div className="newmessage">
					<p><b>User: </b></p>
					<p><b>Message: </b></p>
				</div>
			</div>
		);
	}
}

class App extends React.Component {
	render () {
		return(
			<div className="row">
					<UserForm />
					<MessageBoard />
			</div>
		);
	}
}

//REACT DOM
ReactDOM.render(<App />, document.getElementById('root'));
