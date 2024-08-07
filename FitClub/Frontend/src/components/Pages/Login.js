// src/components/Pages/Login.js
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useDispatch } from 'react-redux';
import { login } from '../redux/authSlice';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Login.css';

export const Login = () => {
  const defaultState = {
    email: "",
    password: "",
    emailError: "",
    passwordError: ""
  };

  const [formState, setFormState] = useState(defaultState);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormState((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };

  const validate = () => {
    let emailError = "";
    let passwordError = "";
    const reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (!formState.email || reg.test(formState.email) === false) {
      emailError = "Email Field is Invalid";
    }

    if (!formState.password) {
      passwordError = "Password field is required";
    }

    if (emailError || passwordError) {
      setFormState((prevState) => ({
        ...prevState,
        emailError,
        passwordError
      }));
      return false;
    }

    return true;
  };

  const submit = () => {
    if (validate()) {
      const { email, password } = formState;

      // Dummy authentication logic
      if (email === 'admin@gmail.com' && password === 'admin123') {
        dispatch(login({ email }));
        navigate("/admindashboard"); 
      } else {
        dispatch(login({ email })); 
        navigate("/"); 
      }
    }
  };

  return (
    <div className="login-page">
      <div className="login-container">
        <div className="container-fluid ps-md-0">
          <div className="row g-0">
            <div className="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
            <div className="col-md-8 col-lg-6 d-flex align-items-center justify-content-center">
              <div className="container">
                <div className="row">
                  <div className="col-md-9 col-lg-8 mx-auto">
                    <h3 className="login-heading mb-4"><b>Welcome back!</b></h3>
                    <form>
                      <div className="form-floating mb-3">
                        <input
                          type="email"
                          className={`form-control ${formState.emailError ? 'invalid' : ''}`}
                          id="email"
                          name="email"
                          placeholder="name@example.com"
                          value={formState.email}
                          onChange={handleInputChange}
                        />
                        <label htmlFor="email">Email address</label>
                        {formState.emailError && <div className="text-danger">{formState.emailError}</div>}
                      </div>
                      <div className="form-floating mb-3">
                        <input
                          type="password"
                          className={`form-control ${formState.passwordError ? 'invalid' : ''}`}
                          id="password"
                          name="password"
                          placeholder="Password"
                          value={formState.password}
                          onChange={handleInputChange}
                        />
                        <label htmlFor="password">Password</label>
                        {formState.passwordError && <div className="text-danger">{formState.passwordError}</div>}
                      </div>
                      
                      <div className="d-grid">
                        <button
                          className="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
                          type="button"
                          onClick={submit}
                        >
                          Sign in
                        </button>
                        <br/>
                        <div className="text-center">
                          <p>Don't have an account? <a className="small" href="/signup">SignUp</a></p>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
