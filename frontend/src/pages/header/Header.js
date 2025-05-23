// Import Bootstrap CSS for styling
import "bootstrap/dist/css/bootstrap.min.css";

// Import necessary components and hooks from React Router and React
import { Link, NavLink, useNavigate } from "react-router-dom";
import { useState } from "react";
import { Nav } from "react-bootstrap";

// Header component definition
function Header() {
  // Get the navigate function from React Router for programmatic navigation
  const navigate = useNavigate();

  return (
    <>
      {/* Main navigation bar */}
      <nav
        className="navbar navbar-expand-lg bg-body-tertiary"
        variant="dark"
        bg="dark"
      >
        <div className="container-fluid">
          {/* Brand/logo section */}
          <a className="navbar-brand" href="/dashboard">
            {/* Use a relative path or Link for navigation */}
            Educator management
          </a>

          {/* Toggler for responsive collapse */}
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          {/* Collapsible navigation links */}
          <div
            className="d-flex justify-content-end collapse navbar-collapse"
            id="navbarSupportedContent"
          >
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              {/* Educators link */}
              <li className="nav-item">
                <Nav
                  onClick={() => navigate("/")}
                  className="nav-link active"
                  aria-current="page"
                >
                  Educators
                </Nav>
              </li>

              {/* Add educator link */}
              <li className="nav-item">
                <Nav
                  className="nav-link active"
                  onClick={() => navigate("/educator")}
                >
                  Add educator
                </Nav>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
}

export default Header;
