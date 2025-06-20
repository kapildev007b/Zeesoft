const API_URL = "http://localhost:8080/api";
const TOKEN = "Bearer my-secret-token"; 

document.getElementById("submissionForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const form = e.target;
  const payload = {
    name: form.name.value,
    email: form.email.value
  };

  try {
    await fetch(`${API_URL}/submit`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": TOKEN
      },
      body: JSON.stringify(payload)
    });
    alert("Form submitted successfully");
    form.reset();
    loadTableData();
  } catch (err) {
    alert("Error submitting form");
    console.error(err);
  }
});

async function loadTableData() {
  try {
    const res = await fetch(`${API_URL}/submissions`, {
      headers: { Authorization: TOKEN }
    });
    const data = await res.json();

    const rows = data.map(s => `
      <tr>
        <td>${s.name}</td>
        <td>${s.email}</td>
        <td>${s.createdAt || "-"}</td>
        <td>${s.ipAddress || "-"}</td>
        <td>${s.location || "-"}</td>
        <td>${s.systemInfo || "-"}</td>
        <td>${s.browserInfo || "-"}</td>
      </tr>
    `).join("");

    const tbody = document.querySelector("#submissionsTable tbody");
    tbody.innerHTML = rows;

    if (!$.fn.DataTable.isDataTable('#submissionsTable')) {
      $('#submissionsTable').DataTable();
    } else {
      $('#submissionsTable').DataTable().clear().rows.add($(rows)).draw();
    }
  } catch (err) {
    console.error("Failed to load table data", err);
  }
}

window.onload = loadTableData;
