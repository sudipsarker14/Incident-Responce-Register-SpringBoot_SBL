/*mysql*/

CREATE DATABASE incident;

-- Use the newly created database
USE incident;

INSERT INTO dropdown_options (type, value) VALUES
('nature_incident', 'IT Related Incident'),
('nature_incident', 'Manmade Incident'),
('nature_incident', 'Natural Calamities Incident'),

('severity', 'Low'),
('severity', 'Medium'),
('severity', 'High'),
('severity', 'Extreme'),

('incident_status', 'Open'),
('incident_status', 'Close'),

('action_required_by', 'Branch Manager'),
('action_required_by', 'PO Head'),
('action_required_by', 'GMO Head');



INSERT INTO dropdown_options (type, value) VALUES
('sub_it_incident', 'Digital Fraud Forgery'),
('sub_it_incident', 'ATM Booth Forgery'),
('sub_it_incident', 'Data Breach'),
('sub_it_incident', 'Phishing Attack');

-- Sub-options for Manmade Incident
INSERT INTO dropdown_options (type, value) VALUES
('sub_manmade_incident', 'Fire Incident'),
('sub_manmade_incident', 'Robbery Incident'),
('sub_manmade_incident', 'Snatching'),
('sub_manmade_incident', 'Violent Protest');

-- Sub-options for Natural Calamities Incident
INSERT INTO dropdown_options (type, value) VALUES
('sub_natural_incident', 'Earthquake'),
('sub_natural_incident', 'Flood'),
('sub_natural_incident', 'Cyclone'),
('sub_natural_incident', 'Landslide');




INSERT INTO user (username, password, role) VALUES
('ituser', 'pass123', 'IT_TEAM'),
('manuser', 'pass123', 'MANMADE_TEAM'),
('natureuser', 'pass123', 'NATURE_TEAM');
