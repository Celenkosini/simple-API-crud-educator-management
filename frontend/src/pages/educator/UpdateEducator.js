import React, { useEffect, useState, useCallback } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

/**
 * Custom hook for managing form state and input changes.
 * @param {Object} initialValues - The initial values for the form fields.
 * @returns {Object} - Form values, change handler, and setter.
 */
const useForm = (initialValues) => {
  const [values, setValues] = useState(initialValues);

  // Handles input changes and updates form state.
  const handleChange = useCallback((event) => {
    const { name, value } = event.target;
    setValues((prevValues) => ({
      ...prevValues,
      [name]: value,
    }));
  }, []);

  return {
    values,
    handleChange,
    setValues,
  };
};

function UpdateEducator() {
  // Get educator ID from route params.
  const { id } = useParams();

  // For navigation after update.
  const navigate = useNavigate();

  // Form state management using custom hook.
  const {
    values: formData,
    handleChange,
    setValues: setFormData,
  } = useForm({
    firstName: "",
    lastName: "",
    email: "",
    specialization: "",
  });

  // Loading and error state.
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Fetch educator data on mount or when ID changes.
  useEffect(() => {
    const fetchEducator = async () => {
      setLoading(true);
      setError(null);

      try {
        const response = await fetch(`http://localhost:8080/educators/${id}`);
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setFormData(data);
      } catch (err) {
        console.error("Error fetching educator:", err);
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchEducator();
  }, [id, setFormData]);

  /**
   * Handles form submission to update educator data.
   * @param {Event} e - Form submit event.
   */
  const handleSubmit = useCallback(
    async (e) => {
      e.preventDefault();

      try {
        const response = await fetch(`http://localhost:8080/educators/${id}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        alert("Educator updated successfully!");
        navigate("/");
      } catch (err) {
        console.error("Error updating educator:", err);
        setError(err.message);
      }
    },
    [id, formData, navigate]
  );

  // Show loading state.
  if (loading) {
    return <div className="text-center">Loading educator data...</div>;
  }

  // Show error state.
  if (error) {
    return <div className="text-center text-danger">Error: {error}</div>;
  }

  // Render update form.
  return (
    <>
      <div className="center-form d-flex justify-content-center mt-5">
        <form onSubmit={handleSubmit}>
          <h1 className="text-center">Update Educator</h1>

          {/* First Name Field */}
          <div className="mb-3">
            <label htmlFor="firstName" className="form-label">
              First Name
            </label>
            <input
              type="text"
              className="form-control"
              id="firstName"
              name="firstName"
              value={formData.firstName || ""}
              onChange={handleChange}
            />
          </div>

          {/* Last Name Field */}
          <div className="mb-3">
            <label htmlFor="lastName" className="form-label">
              Last Name
            </label>
            <input
              type="text"
              className="form-control"
              id="lastName"
              name="lastName"
              value={formData.lastName || ""}
              onChange={handleChange}
            />
          </div>

          {/* Email Field */}
          <div className="mb-3">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              value={formData.email || ""}
              onChange={handleChange}
            />
          </div>

          {/* Specialization Field */}
          <div className="mb-3">
            <label htmlFor="specialization" className="form-label">
              Specialization
            </label>
            <input
              type="text"
              className="form-control"
              id="specialization"
              name="specialization"
              value={formData.specialization || ""}
              onChange={handleChange}
            />
          </div>

          {/* Submit Button */}
          <div className="col-12">
            <button type="submit" className="btn btn-primary">
              Update Educator
            </button>
          </div>
        </form>
      </div>
    </>
  );
}

export default UpdateEducator;
