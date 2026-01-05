import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/dashboard.css'; // Assuming a common dashboard CSS
import API from '../api/api'; // Assuming you have an API utility

const ContractorDashboard = () => {
    const navigate = useNavigate();
    const [jobApplyMessage, setJobApplyMessage] = useState('');

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

    const handleApplyForJob = async (jobId, jobTitle) => {
        setJobApplyMessage(''); // Clear previous messages
        try {
            // Simulate API call to apply for a job
            console.log(`Contractor applying for Job ID: ${jobId} - ${jobTitle}`);
            // In a real application, you would make an API call here:
            // const response = await API.post('/contractor/apply', { jobId: jobId });
            // console.log('Application successful:', response.data);
            setJobApplyMessage(`Successfully applied for "${jobTitle}"!`);
        } catch (error) {
            console.error('Error applying for job:', error);
            setJobApplyMessage('Failed to apply for job. Please try again.');
        }
    };

    // Placeholder for fetching available jobs - to be implemented with real API calls
    const availableJobs = [
        { id: 1, title: 'Fix leaky faucet', description: 'Urgent repair needed for kitchen faucet.' },
        { id: 2, title: 'Electrical wiring inspection', description: 'Annual safety inspection for residential wiring.' },
        { id: 3, title: 'Bathroom Renovation', description: 'Complete renovation of a master bathroom.' },
    ];

    return (
        <div className="dashboard-container">
            <header className="dashboard-header">
                <h1 className="dashboard-title">Contractor Dashboard</h1>
                <nav className="dashboard-nav">
                    <ul>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('available-jobs')}>Available Jobs</button></li>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('my-work-orders')}>My Work Orders</button></li>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('my-work-plans')}>My Work Plans</button></li>
                        <li><button className="nav-button" onClick={() => handleScrollToSection('my-invoices')}>My Invoices</button></li>
                        <li><button onClick={handleLogout} className="logout-button">Logout</button></li>
                    </ul>
                </nav>
            </header>
            <main className="dashboard-main">
                <section id="available-jobs" className="dashboard-section">
                    <h2>Available Jobs</h2>
                    <div className="card">
                        <p>List of jobs available for application will appear here.</p>
                        {jobApplyMessage && <p className="form-message success">{jobApplyMessage}</p>}
                        <ul className="item-list">
                            {availableJobs.map(job => (
                                <li key={job.id}>
                                    <div>
                                        <strong>{job.title}</strong> - {job.description}
                                    </div>
                                    <button
                                        className="primary-button"
                                        onClick={() => handleApplyForJob(job.id, job.title)}
                                    >
                                        Apply Now
                                    </button>
                                </li>
                            ))}
                        </ul>
                    </div>
                </section>

                <section id="my-work-orders" className="dashboard-section">
                    <h2>My Work Orders</h2>
                    <div className="card">
                        <p>Track your submitted work orders and their status.</p>
                        {/* Placeholder for My Work Orders list */}
                        <ul className="item-list">
                            <li>Work Order #101 - Pending Approval <button className="secondary-button">View Status</button></li>
                            <li>Work Order #102 - Approved <button className="secondary-button">View Details</button></li>
                        </ul>
                    </div>
                </section>

                <section id="my-work-plans" className="dashboard-section">
                    <h2>My Work Plans</h2>
                    <div className="card">
                        <p>Initiate work plans for assigned jobs and track progress.</p>
                        {/* Placeholder for My Work Plans list */}
                        <ul className="item-list">
                            <li>Work Plan for Job #102 - In Progress <button className="secondary-button">Update Plan</button></li>
                        </ul>
                    </div>
                </section>

                <section id="my-invoices" className="dashboard-section">
                    <h2>My Invoices</h2>
                    <div className="card">
                        <p>Submit and manage invoices for completed work.</p>
                        {/* Placeholder for My Invoices list */}
                        <ul className="item-list">
                            <li>Invoice #001 - Submitted <button className="secondary-button">View Invoice</button></li>
                        </ul>
                    </div>
                </section>
            </main>
            <footer className="dashboard-footer">
                <p>&copy; 2026 Rentr. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default ContractorDashboard;