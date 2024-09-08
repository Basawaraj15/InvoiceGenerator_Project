const express = require('express');
const cors = require('cors');
const path = require('path');  // Import the path module to resolve file paths
const app = express();
const port = 3001; // Define the port number

app.use(cors()); // Enable CORS to allow frontend requests
app.use(express.json());

// Serve static files (like CSS, JS, and images) from the 'public' directory
app.use(express.static(path.join(__dirname, 'public')));

// Serve the invoice.html file when accessing /invoice
app.get('/invoice', (req, res) => {
    res.sendFile(path.join(__dirname, 'invoice.html')); // Adjust the path to where your invoice.html is located
});

// Invoice API endpoint with example data for different types of invoices
const invoices = {
    standard: { id: 1, name: 'Standard Invoice', amount: 1000 },
    proforma: { id: 2, name: 'Proforma Invoice', amount: 2000 },
    creditNote: { id: 3, name: 'Credit Note', amount: -500 }
};

// API to get invoice data based on type (standard, proforma, or credit note)
app.get('/api/invoice/:type', (req, res) => {
    const { type } = req.params;
    if (invoices[type]) {
      res.json(invoices[type]);
    } else {
      res.status(404).json({ message: 'Invoice type not found' });
    }
});

// Start the server and listen on the defined port
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`); // Use the 'port' variable here
});
