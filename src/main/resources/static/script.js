class UserForm extends React.Component {

	constructor(props) {
		super(props);
		this.state = {user: '', msg: ''};

		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleChange(event) {
		this.setState({[event.target.name]: event.target.value});
	}
	
	handleSubmit(event) {
		alert("submitted: " + this.state.user + " " + this.state.msg);
		event.preventDefault();
	}

	render() {
	return(
				<div className="one-half column">
					<h3>Insert a new message: </h3>
					<form onSubmit={this.handleSubmit}>
						<input type="text" name="user" value={this.state.value} onChange={this.handleChange}/>
						<input type="text" name="msg" value={this.state.value} onChange={this.handleChange}/> 
						<input type="submit" value="Submit Message" />
					</form>
				</div>	
		);
}
}

const api = 'http://localhost:8080/api/messages/';

class Message extends React.Component {
	constructor(props) {
		super(props);
	}
	
	render() {
		return(
			<div className="newmessage">
			<p>user 1</p>
			<p>message</p>
			</div>
			);
	}
}

class Content extends React.Component {

	constructor(props) {
		super(props);
		this.state = {messages: [],};
		
	}
	
	componentDidMount() {
	    fetch(api)
	      .then(response => response.json())
	      .then(data => this.setState({ messages: data.content }));
	    console.log("state", this.state.messages);
	}

	/*
	componentDidMount() {
		fetch(api)
		.then(response => response.json())
		.then(data => {
			let messages = data.content.map((msg => {
				return(
					<div key={msg.content}>
					<p>{msg.message.user}</p>
					</div>
					)
			}))
			this.setState({messages: data.content});
			console.log("state", this.state.messages);
	}
*/
	render() {

		return(
				<div className="newmessage">
				<p>user 2</p>
				<p>message</p>
				</div>
			)
  	}
}


class MessageBoard extends React.Component {
	render () {
	return (
			<div className="one-third column">
				<h3>Message Board: </h3>
				<Content />
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
