import React, { useState } from 'react';
import { Formik } from 'formik';
import * as Yup from 'yup';
import { registerUser } from '../services/api';
import './RegistrationForm.css';

const RegistrationForm = () => {
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const validationSchema = Yup.object().shape({
    username: Yup.string()
      .min(3, 'Username must be at least 3 characters')
      .max(20, 'Username must be at most 20 characters')
      .required('Username is required'),
    email: Yup.string()
      .email('Invalid email address')
      .required('Email is required'),
    password: Yup.string()
      .min(6, 'Password must be at least 6 characters')
      .max(30, 'Password must be at most 30 characters')
      .required('Password is required'),
  });

  const handleSubmit = async (values, { setSubmitting, resetForm }) => {
    try {
      setErrorMessage('');
      setSuccessMessage('');
      
      await registerUser(values);
      setSuccessMessage('Registration successful!');
      resetForm();
    } catch (error) {
      setErrorMessage(error.message);
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <div className="registration-container">
      <h2 className="form-title">User Registration</h2>
      
      {successMessage && (
        <div className="alert success">
          {successMessage}
        </div>
      )}
      
      {errorMessage && (
        <div className="alert error">
          {errorMessage}
        </div>
      )}

      <Formik
        initialValues={{ username: '', email: '', password: '' }}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ 
          values, 
          errors, 
          touched, 
          handleChange, 
          handleBlur, 
          handleSubmit, 
          isSubmitting 
        }) => (
          <form onSubmit={handleSubmit} className="registration-form">
            <div className="form-group">
              <label htmlFor="username">Username</label>
              <input
                type="text"
                id="username"
                name="username"
                value={values.username}
                onChange={handleChange}
                onBlur={handleBlur}
                className={touched.username && errors.username ? 'error-input' : ''}
              />
              {touched.username && errors.username && (
                <div className="error-message">{errors.username}</div>
              )}
            </div>

            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="email"
                id="email"
                name="email"
                value={values.email}
                onChange={handleChange}
                onBlur={handleBlur}
                className={touched.email && errors.email ? 'error-input' : ''}
              />
              {touched.email && errors.email && (
                <div className="error-message">{errors.email}</div>
              )}
            </div>

            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                id="password"
                name="password"
                value={values.password}
                onChange={handleChange}
                onBlur={handleBlur}
                className={touched.password && errors.password ? 'error-input' : ''}
              />
              {touched.password && errors.password && (
                <div className="error-message">{errors.password}</div>
              )}
            </div>

            <button 
              type="submit" 
              disabled={isSubmitting}
              className="submit-button"
            >
              {isSubmitting ? 'Registering...' : 'Register'}
            </button>
          </form>
        )}
      </Formik>
    </div>
  );
};

export default RegistrationForm;