#!/bin/bash

# LeetCode Solutions HTTP Server
# This script starts a Python HTTP server to serve the LeetCode solutions

echo "🚀 Starting LeetCode Solutions HTTP Server..."
echo "📍 Server will be available at: http://localhost:8000"
echo "📁 Serving directory: $(pwd)"
echo ""

# Check if Python is available
if command -v python3 &> /dev/null; then
    echo "✅ Using Python 3"
    python3 -m http.server 8000
elif command -v python &> /dev/null; then
    echo "✅ Using Python 2"
    python -m SimpleHTTPServer 8000
else
    echo "❌ Error: Python is not installed or not in PATH"
    echo "Please install Python and try again."
    exit 1
fi 