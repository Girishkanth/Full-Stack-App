import React from "react";
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="container footer__content">
        <div className="footer__about">
          <h3 className="footer__title">About Us</h3>
          <p>We are dedicated to helping you achieve your fitness goals. Our platform offers personalized workout plans and progress tracking to ensure you stay on track. Join us on your journey to a healthier, more active lifestyle.</p>
        </div>
        <div className="footer__links">
          <h3 className="footer__title">Quick Links</h3>
          <ul>
            <li><a href="#hero">Home</a></li>
            <li><a href="#membership">Membership</a></li>
            <li><a href="#call-to-action">Get Started</a></li>
            <li><a href="/workout">Workout</a></li>
          </ul>
        </div>
        <div className="footer__contact">
          <h3 className="footer__title">Contact Us</h3>
          <ul>
            <li>Email: support@fitclub.com</li>
            <li>Phone: +91 1234567890</li>
            <li><a href="https://www.instagram.com/fitclubbbbb" target="_blank" rel="noopener noreferrer">Instagram</a></li>
          </ul>
        </div>
      </div>
      <div className="footer__bottom">
        <p>&copy; 2024 FITCLUB . All Rights Reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
