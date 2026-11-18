function openModal(id){const el=document.getElementById(id);if(el)el.classList.add('show')}
function closeModal(id){const el=document.getElementById(id);if(el)el.classList.remove('show')}
function editModelFromButton(button){const d=button.dataset;document.getElementById('editName').value=d.name||'';document.getElementById('editUrl').value=d.url||'';document.getElementById('editDescription').value=d.description||'';openModal('editModelModal')}
function editUserFromButton(button){const d=button.dataset;document.getElementById('editUserId').value=d.id||'';document.getElementById('editUserName').value=d.name||'';document.getElementById('editUserEmail').value=d.email||'';document.getElementById('editUserRole').value=d.role||'Étudiant';openModal('editUserModal')}
document.addEventListener('click',e=>{if(e.target.classList.contains('modal-overlay'))e.target.classList.remove('show')});
document.addEventListener('keydown',e=>{if(e.key==='Escape')document.querySelectorAll('.modal-overlay.show').forEach(m=>m.classList.remove('show'))});
