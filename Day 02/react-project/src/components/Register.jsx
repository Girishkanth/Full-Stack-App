import React, { useRef, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import '../components/Login.css';

function Register() {
  let name = useRef(null);
  let email = useRef(null);
  let password = useRef(null);
  let confirmPassword = useRef(null);

  const [error, setError] = useState({
    name: false,
    email: false,
    password: false,
    confirmPassword: false,
    passwordsMatch: true
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    
    const nameValue = name.current.value;
    const emailValue = email.current.value;
    const passwordValue = password.current.value;
    const confirmPasswordValue = confirmPassword.current.value;

    if (nameValue && emailValue && passwordValue && confirmPasswordValue && passwordValue === confirmPasswordValue) {
      console.log('Name:', nameValue);
      console.log('Email:', emailValue);
      console.log('Password:', passwordValue);
      console.log('Confirm Password:', confirmPasswordValue);
    } else {
      console.log("Error");

      setError({
        name: !nameValue,
        email: !emailValue,
        password: !passwordValue,
        confirmPassword: !confirmPasswordValue,
        passwordsMatch: passwordValue !== confirmPasswordValue
      });
    }
  };

  return (
    <div className='register-box'>
      <h1>Register</h1>
      <br />
      <Box
        id='logBox'
        component="form"
        sx={{
          '& > :not(style)': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField inputRef={name} id="outlined-name" label="Username" variant="outlined" required />
        {error.name && <p style={{ color: 'red', fontSize: '12px', paddingLeft: '5%' }}>Fill the username</p>}
        <br />
        <TextField inputRef={email} id="outlined-email" label="Email" variant="outlined" required />
        {error.email && <p style={{ color: 'red', fontSize: '12px', paddingLeft: '5%' }}>Fill the email</p>}
        <br />
        <TextField inputRef={password} id="outlined-password" label="Password" variant="outlined" type='password' required />
        {error.password && <p style={{ color: 'red', fontSize: '12px', paddingLeft: '5%' }}>Fill the password</p>}
        <br />
        <TextField inputRef={confirmPassword} id="outlined-confirm-password" label="Confirm Password" variant="outlined" type='password' required />
        {error.confirmPassword && <p style={{ color: 'red', fontSize: '12px', paddingLeft: '5%' }}>Confirm the password</p>}
        {!error.passwordsMatch && <p style={{ color: 'red', fontSize: '12px', paddingLeft: '5%' }}>Passwords do not match</p>}
        <br />
        <Button className='register-but' id='register-but' variant="contained" onClick={handleSubmit}>REGISTER</Button>
      </Box>
    </div>
  );
}

export default Register;
