// Import React and required hooks
import React, { useState } from "react";

// Import Bootstrap CSS for styling
import "bootstrap/dist/css/bootstrap.min.css";

// Import useNavigate hook from react-router-dom for navigation
import { useNavigate } from "react-router-dom";

// AddEducator component definition
function AddEducator() {
  // State to hold form data
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    specialization: "",
  });

  // Hook to programmatically navigate to different routes
  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Log form data for debugging
    console.log(formData);

    try {
      // Send POST request to add educator
      const response = await fetch("http://localhost:8080/educators", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      // Check if request was successful
      if (response.ok) {
        alert("Educator added successfully");
        navigate("/"); // Redirect to home page
      } else {
        alert("Failed to add educator");
      }
    } catch (error) {
      // Handle errors
      console.error("Error adding educator:", error);
      alert("Something went wrong. Please try again.");
    }
  };

  return (
    <>
      {/* Centered form container */}
      <div className="center-form mt-5 d-flex justify-content-center">
        <form onSubmit={handleSubmit}>
          {/* Form Title */}
          <h1 className="text-center mb-4">Add Educator</h1>

          {/* First Name Field */}
          <div className="mb-3">
            <label htmlFor="firstName" className="form-label">
              First Name
            </label>
            <input
              id="firstName"
              type="text"
              className="form-control"
              value={formData.firstName}
              onChange={(e) =>
                setFormData({ ...formData, firstName: e.target.value })
              }
              placeholder="Enter first name"
              required
            />
          </div>

          {/* Last Name Field */}
          <div className="mb-3">
            <label htmlFor="lastName" className="form-label">
              Last Name
            </label>
            <input
              id="lastName"
              type="text"
              className="form-control"
              value={formData.lastName}
              onChange={(e) =>
                setFormData({ ...formData, lastName: e.target.value })
              }
              placeholder="Enter last name"
              required
            />
          </div>

          {/* Email Field */}
          <div className="mb-3">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              id="email"
              type="email"
              className="form-control"
              value={formData.email}
              onChange={(e) =>
                setFormData({ ...formData, email: e.target.value })
              }
              placeholder="Enter email"
              required
            />
          </div>

          {/* Specialization Field */}
          <div className="mb-3">
            <label htmlFor="specialization" className="form-label">
              Specialization
            </label>
            <input
              id="specialization"
              type="text"
              className="form-control"
              value={formData.specialization}
              onChange={(e) =>
                setFormData({ ...formData, specialization: e.target.value })
              }
              placeholder="Enter specialization"
              required
            />
          </div>

          {/* Submit Button */}
          <div className="col-12">
            <button type="submit" className="btn btn-primary w-100">
              Add Educator
            </button>
          </div>
        </form>
      </div>
    </>
  );
}

export default AddEducator;
