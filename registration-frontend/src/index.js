// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './index.css';

// Create a root element to render the React app
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// Optional: If you want to use service workers (PWA)
// import * as serviceWorker from './serviceWorker';
// serviceWorker.unregister();