import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/dashboard.css'; // Assuming a common dashboard CSS
import API from '../api/api'; // Assuming you have an API utility

const AgentDashboard = () => {
    const navigate = useNavigate();
    const [jobTitle, setJobTitle] = useState('');
    const [jobDescription, setJobDescription] = useState('');
    const [jobUploadMessage, setJobUploadMessage] = useState('');

    const handleLogout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        navigate('/login');
    };

    const handleScrollToSection = (id) => {
        const element = document.getElementById(id);
        if (element) {
            element.scrollIntoView({ behavior: 'smooth' });
        }
    };

    const handleSubmitJob = async (e) => {
        e.preventDefault();
        setJobUploadMessage(''); // Clear previous messages

        if (!jobTitle || !jobDescription) {
            setJobUploadMessage('Please fill in both job title and description.');
            return;
        }

        try {
            // Simulate API call to upload a job
            console.log('Submitting new job:', { jobTitle, jobDescription });
            // In a real application, you would make an API call here:
            // const response = await API.post('/agent/jobs', { title: jobTitle, description: jobDescription });
            // console.log('Job created:', response.data);
            setJobUploadMessage('Job "' + jobTitle + '" created successfully!');
            setJobTitle('');
            setJobDescription('');
        } catch (error) {
            console.error('Error creating job:', error);
            setJobUploadMessage('Failed to create job. Please try again.');
        }
    };

    const handleViewWorkOrder = (workOrderId) => {
        console.log('Viewing work order:', workOrderId);
        // In a real application, this would open a modal or navigate to a detail page
        alert(`Viewing details for Work Order #${workOrderId}`);
    };

    // Placeholder for fetching work orders - to be implemented with real API calls
    const workOrders = [
        { id: 123, status: 'Pending Review' },
        { id: 124, status: 'Pending Review' },
        { id: 125, status: 'Approved' },
    ];

    return (
        <div className="dashboard-container">
            <header className="dashboard-header">
                <h1 className="dashboard-title">Agent Dashboard</h1>
                <nav className="dashboard-nav">
                    <ul>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('upload-job')}>Upload Job</button></li>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('review-work-orders')}>Review Work Orders</button></li>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('assigned-work')}>Assigned Work</button></li>
                        <li><button onClick={handleLogout} className="logout-button">Logout</button></li>
                    </ul>
                </nav>
            </header>
            <main className="dashboard-main">
                <section id="upload-job" className="dashboard-section">
                    <h2>Upload New Job</h2>
                    <div className="card">
                        <form onSubmit={handleSubmitJob}>
                            <div className="input-group">
                                <label htmlFor="jobTitle">Job Title</label>
                                <input
                                    type="text"
                                    id="jobTitle"
                                    value={jobTitle}
                                    onChange={(e) => setJobTitle(e.target.value)}
                                    placeholder="Enter job title"
                                    required
                                />
                            </div>
                            <div className="input-group">
                                <label htmlFor="jobDescription">Job Description</label>
                                <textarea
                                    id="jobDescription"
                                    value={jobDescription}
                                    onChange={(e) => setJobDescription(e.target.value)}
                                    placeholder="Provide a detailed job description"
                                    rows="4"
                                    required
                                ></textarea>
                            </div>
                            <button type="submit" className="primary-button">Create Job</button>
                            {jobUploadMessage && <p className="form-message">{jobUploadMessage}</p>}
                        </form>
                    </div>
                </section>

                <section id="review-work-orders" className="dashboard-section">
                    <h2>Review Contractor Work Orders</h2>
                    <div className="card">
                        <p>List of work orders submitted by contractors will appear here for review, approval, and assignment.</p>
                        <ul className="item-list">
                            {workOrders.map(order => (
                                <li key={order.id}>
                                    Work Order #{order.id} - {order.status}
                                    <button
                                        className="secondary-button"
                                        onClick={() => handleViewWorkOrder(order.id)}
                                    >
                                        View
                                    </button>
                                </li>
                            ))}
                        </ul>
                    </div>
                </section>

                <section id="assigned-work" className="dashboard-section">
                    <h2>Your Assigned Work</h2>
                    <div className="card">
                        <p>Overview of jobs assigned to contractors will be displayed here.</p>
                    </div>
                </section>
            </main>
            <footer className="dashboard-footer">
                <p>&copy; 2026 Rentr. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default AgentDashboard;