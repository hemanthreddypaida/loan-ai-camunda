# Loan AI Camunda Integration 🚀

This project showcases how to integrate Camunda BPM workflows with a Java External Task Worker that connects to generative AI (e.g., OpenAI GPT) to support loan application processing in the banking sector.

### 🌟 Features

✅ BPMN process for loan applications  
✅ Java External Task Worker (Maven)  
✅ AI-powered narrative analysis using GPT  
✅ Docker Compose for easy setup  
✅ Ready-to-use AI prompt library  
✅ Human-in-the-loop: AI supports, human approves  

### 📂 Repository Structure

/loan-ai-camunda  
├── bpmn-models/ → BPMN models  
├── ai-loan-worker/ → Java worker code  
├── prompts/ → Example AI prompts  
├── docker-compose.yaml → Docker setup  
├── architecture.png → System diagram  
├── README.md → Project instructions  

---

### 💼 Use Case

- Automate loan narrative assessments  
- Provide AI recommendations to loan officers  
- Accelerate decision-making while maintaining human oversight  
- Extendable for other banking workflows: KYC, fraud alerts, complaint triage

---

### 🚀 Quick Start

```bash
docker-compose up
cd ai-loan-worker
mvn clean package
java -jar target/ai-loan-worker-1.0-SNAPSHOT.jar
