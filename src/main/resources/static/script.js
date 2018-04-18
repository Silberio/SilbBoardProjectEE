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

var Message = React.createClass({

render: function() {
		   return (
			<div className="newmessage">
				<p>Message: {this.props.message.message}</p>
				<p>User: {this.props.message.user}</p>
			</div>);
		}
});

	    
var App = React.createClass({
	
loadMessages: function() {
	    var self = this;
	    $.ajax({
	      url: api
	      }).then(function (data) {
	      self.setState({messages: data._embedded.messages});
	      console.log(data)
	    });
	  },
	
getInitialState: function () {
		    return {messages: []};
		  },

componentDidMount: function () {
		    this.loadMessages();
		  },
		  
	render() {

		return(
				<MessageBoard messages={this.state.messages}/>
			)
  	}
});


var MessageBoard = React.createClass({
	
render: function() {
	    var msgs = [];
	    this.props.messages.forEach(function(messages) {
	    	msgs.push(<Message messages={message}/>
	    		); 
	    	});
	    	
	    return (
	    		
	    	<div className="one-third column">
				<h3>Message Board: </h3>
				<div>
					{msgs}
				</div>
			</div>);
		
	  }
	

});

var Content = React.createClass({
	render () {
		return(
			<div className="row">
					<UserForm />
					<App />
			</div>

		);
	}
});

// REACT DOM
ReactDOM.render(<Content />, document.getElementById('root'));
