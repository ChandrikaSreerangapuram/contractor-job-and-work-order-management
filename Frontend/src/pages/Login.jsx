import React, { useState } from "react";
import API from "../api/api";
import { useNavigate } from "react-router-dom";
import "../styles/login.css"; // Using a centralized style file for login

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState(""); // Added password state
  const [role, setRole] = useState("AGENT");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");

    if (!email || !password || !role) {
      setError("Please fill in all fields (email, password, and role).");
      return;
    }

    try {
      const response = await API.post(
        "/auth/login",
        {
          email: email,
          password: password, // Include password in the API call
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      localStorage.setItem("token", response.data);
      localStorage.setItem("role", role);

      if (role === "AGENT") {
        navigate("/agent");
      } else {
        navigate("/contractor");
      }
    } catch (err) {
      console.error("Login error:", err);
      // More specific error handling might be needed based on API response
      setError("Login failed. Please check your credentials and try again.");
    }
  };

  return (
    <div className="login-wrapper">
      <div className="login-card">
        <h2 className="login-title">Welcome to Rentr</h2>
        <form className="login-form" onSubmit={handleLogin}>
          {error && <p className="error-message">{error}</p>}

          <div className="input-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="password">Password</label> {/* Added password input */}
            <input
              type="password"
              id="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <div className="input-group">
            <label htmlFor="role">Role</label>
            <select
              id="role"
              value={role}
              onChange={(e) => setRole(e.target.value)}
              required
            >
              <option value="AGENT">Agent</option>
              <option value="CONTRACTOR">Contractor</option>
            </select>
          </div>

          <button type="submit" className="login-button">Sign In</button>
        </form>
      </div>
    </div>
  );
}

export default Login;

